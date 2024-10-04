package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import md.zoom.model.enums.AccountStatusEnum;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountEntity {

    @Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "fam")
    private String fam;

    @Column(name = "im")
    private String im;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "registereddate")
    @CreationTimestamp
    private Date registeredDate;

    @Column(name = "pass")
    private String password;

    @Column(name = "status")
    private String status = AccountStatusEnum.ENABLE.getValue();

    @Column(name = "invitecode")
    private String inviteCode;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "linkaccountrole", schema = "public",
            joinColumns = {
                    @JoinColumn(name = "accountid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "accountroleid")
            }
    )
    private AccountRoleEntity role;


    @Column(name = "decoded_pass")
    private String decodedPass;
}
