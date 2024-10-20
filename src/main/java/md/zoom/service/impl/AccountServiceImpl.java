package md.zoom.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import md.kobalt.security.config.JwtService;
import md.kobalt.security.exception.ForbiddenException;
import md.kobalt.security.exception.JwtAuthenticationException;
import md.kobalt.security.exception.WebTokenException;
import md.kobalt.security.model.dto.PageParamDto;
import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.user.JwtUserDetails;
import md.zoom.config.AppMapper;
import md.zoom.model.dto.AccountDto;
import md.zoom.model.dto.AccountViewDto;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.AccountRoleEntity;
import md.zoom.model.entity.view.AccountViewEntity;
import md.zoom.model.enums.AccountRoleEnum;
import md.zoom.model.enums.AccountStatusEnum;
import md.zoom.model.input.RegisterRequestExtended;
import md.zoom.repository.AccountRepository;
import md.zoom.repository.AccountRoleRepository;
import md.zoom.repository.spec.AccountSpecification;
import md.zoom.repository.spec.AccountViewSpecification;
import md.zoom.repository.view.AccountViewRepository;
import md.zoom.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

import static md.kobalt.security.utils.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Value("${jwt.token.expired}")
    private Long expiredToken;
    @Value("${jwt.token.refresh.expired}")
    private Long expiredRefreshToken;

    private final AccountRepository accountRepository;
    private final AccountRoleRepository accountRoleRepository;
    private final AccountViewRepository accountViewRepository;
    private final AppMapper appMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        log.info("Request to auth" + request.toString());
        if (request.getUserName() == null && request.getEmail() == null) {
            throw new WebTokenException(EMAIL_REQUIRED.getMessage());
        }
        var user = accountRepository.findByEmailOrUserName(request.getEmail(), request.getUserName()).orElseThrow(() -> new JwtAuthenticationException(ID_NOT_FOUND));


        if (!user.getStatus().equals(AccountStatusEnum.ENABLE.getValue())) {
            throw new ForbiddenException(ACCOUNT_NOT_ENABLE.getMessage());
        }

        if (request.getUserName() != null)
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUserName(),
                            request.getPassword()
                    )
            );
        else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }


        JwtUserDetails jwtUserDetails = JwtUserDetails.builder()
                .id(user.getAccountId().toString())
                .email(user.getEmail())
                .userName(user.getUserName())
                .password(user.getPassword())
                .role(user.getRole().getAccountRoleName())
                .build();

        var jwtToken = jwtService.generateToken(jwtUserDetails, expiredToken);
        var jwtTokenRefresh = jwtService.generateToken(jwtUserDetails, expiredRefreshToken);
        return AuthenticationResponse.builder()
                .acceptToken(jwtToken)
                .refreshToken(jwtTokenRefresh)
                .build();
    }

    @Override
    public AccountViewDto getMyProfile() {
        AccountEntity accountEntity = getCurrentAccount();
        AccountViewEntity accountViewEntity = accountViewRepository.findById(accountEntity.getAccountId()).orElseThrow();
        AccountViewDto accountViewDto = appMapper.map(accountViewEntity);
        return accountViewDto;
    }

    @Override
    public AccountEntity getCurrentAccount() {
        JwtUserDetails jwtUserDetails = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (jwtUserDetails.getId() != null) {
            AccountEntity accountEntityById = findById(Long.valueOf(jwtUserDetails.getId()));
            AccountEntity accountEntityByEmail = accountRepository.findByEmail(jwtUserDetails.getEmail()).orElseThrow(() -> new JwtAuthenticationException(ACCOUNT_NOT_FOUND));

            if (!AccountRoleEnum.ADMIN.getValue().equals(accountEntityByEmail.getRole().getAccountRoleName())
                    || !accountEntityById.getAccountId().toString().equals(jwtUserDetails.getId())) {
                throw new JwtAuthenticationException(ACCOUNT_IS_NOT_OWNER);
            }
            return accountEntityById;
        }
        return accountRepository.findByEmail(jwtUserDetails.getEmail()).orElseThrow(() -> new JwtAuthenticationException(ACCOUNT_NOT_FOUND));

    }

    @Override
    public Page<AccountDto> accountsPage(PageParamDto pageParamDto) {
        Specification<AccountEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new AccountSpecification(filterCriteria));

        Page<AccountEntity> page = accountRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        Page<AccountDto> pageDto = page.map(r -> {
            AccountDto accountViewDto = appMapper.map(r);

            return accountViewDto;
        });
        return pageDto;
    }

    @Override
    public Page<AccountViewDto> getAccountViewDtoPage(PageParamDto pageParamDto) {
        Specification<AccountViewEntity> masterSpec = null;
        for (FilterCriteria filterCriteria : pageParamDto.getCriteria())
            masterSpec = Specification.where(masterSpec).and(new AccountViewSpecification(filterCriteria));

        Page<AccountViewEntity> page = accountViewRepository.findAll(masterSpec, pageParamDto.getPageRequest());
        return page.map(appMapper::map);
    }

    @Override
    public void register(RegisterRequestExtended request) {
        log.info("Registration  request:" + request.toString());
        log.info("Registration email and password:" + request.getEmail() + ": ", request.getPassword());
        verifyExistedEmailAndUserName(request);
        AccountRoleEntity accountRoleEntity = accountRoleRepository.findByAccountRoleName(AccountRoleEnum.USER.getValue());
        AccountEntity accountEntity = appMapper.map(request);
        accountEntity.setRole(accountRoleEntity);
        accountEntity.setInviteCode(generateNumber().toString());
        accountEntity.setDecodedPass(request.getPassword());
        accountEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        accountEntity = accountRepository.save(accountEntity);


        log.info("Registration  account:" + accountEntity);
    }

    private AccountEntity findById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new JwtAuthenticationException(ID_NOT_FOUND));
    }

    private void verifyExistedEmailAndUserName(RegisterRequestExtended request) {
        AccountEntity existedAccountEntity = accountRepository.findByEmailOrUserName(request.getEmail(), request.getUserName()).orElseThrow();
        if (existedAccountEntity != null) {
            throw new ForbiddenException("Email or username are already existed");
        }
    }

    private Long generateNumber() {
        Random rand = new Random();
        return rand.nextLong(100000000L);
    }
}
