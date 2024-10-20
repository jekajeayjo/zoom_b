package md.zoom.repository.view;

import md.zoom.model.entity.view.MenuCategoryViewEntity;
import md.zoom.model.entity.view.MenuItemViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemViewRepository extends JpaRepository<MenuItemViewEntity,Long>, JpaSpecificationExecutor<MenuItemViewEntity> {
}
