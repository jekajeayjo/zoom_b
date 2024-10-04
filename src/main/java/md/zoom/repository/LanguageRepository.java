package md.zoom.repository;

import md.zoom.model.entity.LanguageEntity;
import md.zoom.model.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long>, JpaSpecificationExecutor<LanguageEntity> {
}
