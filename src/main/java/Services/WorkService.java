package Services;

import HibernateDAO.Implementations.WorkDao;
import Models.Work;

public class WorkService extends GenericService<Work> {
    public WorkService(){
        super(new WorkDao(), Work.class);
    }
}
