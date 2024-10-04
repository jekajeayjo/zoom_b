package md.zoom.repository;

import md.zoom.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long>, JpaSpecificationExecutor<AccountEntity> {
    Optional<AccountEntity> findByEmailOrUserName(String email,String userName);
    Optional<AccountEntity> findByEmail(String email);
    Optional<AccountEntity> findByUserName(String userName);
}
