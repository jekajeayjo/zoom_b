package md.zoom.repository.view;

import md.zoom.model.entity.view.AccountViewEntity;
import md.zoom.model.entity.view.MenuCategoryViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryViewRepository extends JpaRepository<MenuCategoryViewEntity,Long>, JpaSpecificationExecutor<MenuCategoryViewEntity> {
}
