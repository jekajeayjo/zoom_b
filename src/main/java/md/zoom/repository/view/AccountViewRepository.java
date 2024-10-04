package md.zoom.repository.view;

import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.view.AccountViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountViewRepository extends JpaRepository<AccountViewEntity,Long>, JpaSpecificationExecutor<AccountViewEntity> {
}
