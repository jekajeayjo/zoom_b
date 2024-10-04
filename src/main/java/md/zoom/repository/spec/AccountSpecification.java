package md.zoom.repository.spec;

import md.kobalt.security.repository.specifiaction.FilterCriteria;
import md.kobalt.security.repository.specifiaction.JpaAbstractSpec;
import md.zoom.model.entity.AccountEntity;

import java.io.Serial;


public class AccountSpecification extends JpaAbstractSpec<AccountEntity> {

    @Serial
    private static final long serialVersionUID = 1L;

    public AccountSpecification(FilterCriteria criteria) {
        super(criteria);
    }
}
