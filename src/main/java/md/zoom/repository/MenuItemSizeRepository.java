package md.zoom.repository;

import md.zoom.model.entity.MenuItemEntity;
import md.zoom.model.entity.MenuItemSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemSizeRepository extends JpaRepository<MenuItemSizeEntity, Long>, JpaSpecificationExecutor<MenuItemSizeEntity> {
}
