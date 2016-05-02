package HibernateDAO.Implementations;

import HibernateDAO.HibernateUtils;
import HibernateDAO.Interfaces.IDao;
import Models.Department;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

public class GenericEntityDao<T> implements IDao<T> {

    private HibernateUtils utils = HibernateUtils.getInstance();
    private Session currentSession;
    private Transaction currentTransaction;
    private Class<T> entityClass;


    public GenericEntityDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

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

    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public T findById(int id) {
        return (T)getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * This method deletes instance, but not it's dependencies.
     * In case of using this , method to entity with dependencies exception will be thrown!
     * To delete entity with it's dependencies use deleteByPK(entity) method!
     * @param entity - entity, which PK will be used for deletion
     */
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(int id) {
        System.out.print("pk = " + id);
        Object persistentInstance = getCurrentSession().get(getEntityClass(), id);
        if (persistentInstance != null) {
            getCurrentSession().delete(persistentInstance);
        }
    }

    public List<T> findAll() {
        return getCurrentSession().createCriteria(getEntityClass())
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    public T getByUniqueAttribute(String attrName, String value){
        return (T) getCurrentSession().createCriteria(entityClass)
                .add(Restrictions.eq( attrName, value ))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .uniqueResult();
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
    public Class<T> getEntityClass() {
        return entityClass;
    }
}
