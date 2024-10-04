package md.zoom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accountrole", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountRoleEntity {

    @Id
    @Column(name = "accountroleid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountRoleGenerator")
    private Long accountRoleId;

    @Column(name = "code")
    private String accountRoleName;
}
