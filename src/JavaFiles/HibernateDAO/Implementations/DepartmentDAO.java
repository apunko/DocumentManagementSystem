package JavaFiles.HibernateDAO.Implementations;
import JavaFiles.HibernateDAO.Utils;
import JavaFiles.Models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private Department dep = new Department();
    public DepartmentDAO(){

    }

    private Utils utils = Utils.getInstance();
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = utils.openSession();
        if (currentSession == null) {
            System.err.println(utils==null);
        }
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = utils.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public ArrayList<Department> findAll() {
        return (ArrayList<Department>) getCurrentSession().createCriteria(Department.class).list();
    }

    public Department findByPK(Integer pk) {
        Session cs = getCurrentSession();
        return (Department) cs.get(dep.getClass(), pk);
    }

    public Session getCurrentSession() {
        return currentSession;
    }
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

}
