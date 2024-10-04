package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.AccountEntity;
import md.zoom.model.entity.view.AccountViewEntity;

import java.io.Serial;


public class AccountViewSpecification extends JpaAbstractSpec<AccountViewEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public AccountViewSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
