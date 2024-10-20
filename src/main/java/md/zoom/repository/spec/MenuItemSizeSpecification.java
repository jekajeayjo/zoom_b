package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.MenuCategoryEntity;
import md.zoom.model.entity.MenuItemSizeEntity;

import java.io.Serial;


public class MenuItemSizeSpecification extends JpaAbstractSpec<MenuItemSizeEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public MenuItemSizeSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
