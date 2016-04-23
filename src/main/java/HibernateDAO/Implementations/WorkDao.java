package HibernateDAO.Implementations;

import Models.Work;

public class WorkDao extends GenericEntityDao<Work>{
    public WorkDao() {
        super(Work.class);
    }
}