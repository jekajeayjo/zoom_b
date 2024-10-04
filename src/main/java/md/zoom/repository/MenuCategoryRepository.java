package md.zoom.repository;

import md.zoom.model.entity.MenuCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategoryEntity, Long>, JpaSpecificationExecutor<MenuCategoryEntity> {
}
