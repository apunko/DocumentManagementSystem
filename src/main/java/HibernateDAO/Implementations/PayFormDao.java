package HibernateDAO.Implementations;

import Models.PayForm;

public class PayFormDao extends GenericEntityDao<PayForm>{
    public PayFormDao() {
        super(PayForm.class);
    }
}