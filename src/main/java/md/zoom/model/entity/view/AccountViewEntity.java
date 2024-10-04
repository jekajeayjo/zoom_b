package md.zoom.model.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "accountview", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountViewEntity {

    @Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "fio")
    private String fio;

    @Column(name = "username")
    private String userName;

    @Column(name = "registereddate")
    private LocalDate registeredDate;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private String status;


}
