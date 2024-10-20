package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.view.MenuCategoryViewEntity;
import md.zoom.model.entity.view.MenuItemViewEntity;

import java.io.Serial;


public class MenuItemViewSpecification extends JpaAbstractSpec<MenuItemViewEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public MenuItemViewSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
