package md.zoom.repository;

import md.zoom.model.entity.MenuCategoryLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuCategoryLanguageRepository extends JpaRepository<MenuCategoryLanguageEntity, Long>, JpaSpecificationExecutor<MenuCategoryLanguageEntity> {
    Optional<MenuCategoryLanguageEntity> findByMenuCategoryIdAndLanguageId(Long menuCategoryId, Long languageId);

    List<MenuCategoryLanguageEntity> findByMenuCategoryId(Long menuCategoryId);
}
