package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.MenuCategoryEntity;

import java.io.Serial;


public class MenuCategorySpecification extends JpaAbstractSpec<MenuCategoryEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public MenuCategorySpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
