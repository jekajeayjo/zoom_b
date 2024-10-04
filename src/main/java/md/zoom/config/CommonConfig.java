package md.zoom.config;

import lombok.RequiredArgsConstructor;
import md.kobalt.security.exception.EntityNotFoundException;
import md.kobalt.security.exception.ForbiddenException;
import md.kobalt.security.user.JwtUserDetails;
import md.kobalt.security.utils.ErrorMessage;
import md.zoom.config.mapping.AppMapper;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.enums.AccountStatusEnum;
import md.zoom.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Properties;

//@AutoConfiguration
@Configuration
@RequiredArgsConstructor
//@Import({ ApplicationConfig.class })
//@ComponentScan(basePackages = { "md.kobalt.security.config.ApplicationConfig"})
public class CommonConfig {
    private final AccountRepository accountRepository;
    private final AppMapper appMapper;

    @Value("${mail.username}")
    String username;
    @Value("${mail.password}")
    String password;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> getJwtUserDetails(username);
    }


    private JwtUserDetails getJwtUserDetails(String userName) {
        AccountEntity accountEntity = accountRepository.findByEmailOrUserName(userName,userName).orElseThrow(() -> new EntityNotFoundException(ErrorMessage.ID_NOT_FOUND.getMessage()));
        if (!AccountStatusEnum.ENABLE.getValue().equals(accountEntity.getStatus())) {
            throw new ForbiddenException("Account  is blocked");
        }
        JwtUserDetails jwtUserDetails = appMapper.mapToDetails(accountEntity);
        jwtUserDetails.setRole(accountEntity.getRole().getAccountRoleName());
        return jwtUserDetails;
    }

//    @Bean
//    public Session getSession() {
//        Properties prop = new Properties();
//        prop = new Properties();
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.socketFactory.port", "465");
//        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", "465");
//
//        return Session.getInstance(prop,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });
//    }

}
