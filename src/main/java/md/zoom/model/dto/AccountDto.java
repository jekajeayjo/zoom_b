package md.zoom.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {
    private Long accountId;
    private String userName;
    private String email;
    private String fam;
    private String im;
    private String phoneNumber;
    private Date registeredDate;
    private String role;
    private String status;
}
