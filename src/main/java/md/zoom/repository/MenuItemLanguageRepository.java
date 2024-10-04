package md.zoom.repository;

import md.zoom.model.entity.MenuCategoryLanguageEntity;
import md.zoom.model.entity.MenuItemLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuItemLanguageRepository extends JpaRepository<MenuItemLanguageEntity, Long>, JpaSpecificationExecutor<MenuItemLanguageEntity> {
    Optional<MenuItemLanguageEntity> findByMenuItemIdAndLanguageId(Long menuItemId, Long languageId);
    List<MenuItemLanguageEntity> findByMenuItemId(Long menuItemId);

}
