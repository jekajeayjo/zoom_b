package md.zoom.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountViewDto {
    private Long accountId;

    private String fio;

    private String userName;

    private LocalDate registeredDate;

    private String phoneNumber;

    private String code;

    private String status;
}
