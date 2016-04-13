package JavaFiles.HibernateDAO.Implementations;

import JavaFiles.HibernateDAO.HibernateUtils;
import JavaFiles.HibernateDAO.Interfaces.IDao;
import JavaFiles.HibernateDAO.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import sun.rmi.runtime.Log;

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


    @Override
    public Session openCurrentSession() {
        currentSession = utils.openSession();
        if (currentSession == null) {
            System.err.println(utils==null);
        }
        return currentSession;
    }

    @Override
    public Session openCurrentSessionWithTransaction() {
        currentSession = utils.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    @Override
    public void closeCurrentSession() {
        currentSession.close();
    }

    @Override
    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }



    @Override
    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public T findById(int id) {
        return (T)getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * This method deletes instance, but not it's dependencies.
     * In case of using this , method to entity with dependencies exception will be thrown!
     * To delete entity with it's dependencies use deleteByPK(entity) method!
     * @param entity - entity, which PK will be used for deletion
     */
    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(int id) {
        System.out.print("pk = " + id);
        Object persistentInstance = getCurrentSession().get(getEntityClass(), id);
        if (persistentInstance != null) {
            getCurrentSession().delete(persistentInstance);
        }
    }

    @Override
    public List<T> findAll() {
        return getCurrentSession().createCriteria(getEntityClass()).list();
    }
/*
    @Override
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public List<T> getModelListByStringField(String fieldName, String fieldValue) {
        return getCurrentSession().createCriteria(entityClass)
                .add(Restrictions.eq(fieldName, fieldValue)).list();
    }

    @Override
    public T getModelByUniqueStringField(String fieldName, String fieldValue) {
        return (T) getCurrentSession().createCriteria(entityClass)
                .add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
    }

*/
    // GETTERS AND SETTERS
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
