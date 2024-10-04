package md.zoom.repository;

import md.zoom.model.entity.AccountRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRoleEntity,Long> {
    AccountRoleEntity findByAccountRoleName(String accountRoleName);
}
