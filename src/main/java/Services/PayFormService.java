package Services;

import HibernateDAO.Implementations.PayFormDao;
import Models.PayForm;

public class PayFormService extends GenericService<PayForm> {
    public PayFormService(){
        super(new PayFormDao(), PayForm.class);
    }
}
