package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.view.MenuCategoryViewEntity;

import java.io.Serial;


public class MenuCategoryViewSpecification extends JpaAbstractSpec<MenuCategoryViewEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public MenuCategoryViewSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
