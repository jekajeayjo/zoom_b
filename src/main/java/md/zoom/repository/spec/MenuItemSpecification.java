package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.MenuCategoryEntity;
import md.zoom.model.entity.MenuItemEntity;

import java.io.Serial;


public class MenuItemSpecification extends JpaAbstractSpec<MenuItemEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public MenuItemSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
