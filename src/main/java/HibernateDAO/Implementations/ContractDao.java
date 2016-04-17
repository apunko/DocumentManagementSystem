package HibernateDAO.Implementations;

import Models.Contract;
import Models.User;
import org.hibernate.criterion.Restrictions;

public class ContractDao extends GenericEntityDao<Contract> {

    public ContractDao( ) {
        super(Contract.class);
    }
}