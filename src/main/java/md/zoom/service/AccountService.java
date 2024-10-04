package md.zoom.service;

import md.kobalt.security.auth.AuthenticationRequest;
import md.kobalt.security.auth.AuthenticationResponse;
import md.kobalt.security.model.dto.PageParamDto;
import md.zoom.model.dto.AccountDto;
import md.zoom.model.dto.AccountViewDto;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.input.RegisterRequestExtended;
import org.springframework.data.domain.Page;

public interface AccountService {

    AuthenticationResponse authenticate(AuthenticationRequest request);


    AccountViewDto getMyProfile();

    AccountEntity getCurrentAccount();

    Page<AccountDto> accountsPage(PageParamDto pageParamDto);

    Page<AccountViewDto> getAccountViewDtoPage(PageParamDto pageParamDto);

    void register(RegisterRequestExtended request);
}
