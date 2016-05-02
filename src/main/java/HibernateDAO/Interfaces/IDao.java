package HibernateDAO.Interfaces;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface IDao <T> {

    Session openCurrentSession();

    Session openCurrentSessionWithTransaction();

    void closeCurrentSession();

    void closeCurrentSessionWithTransaction();

    void persist(T entity);

    void update(T entity);

    T findById(int id);

    void delete(T entity);

    void deleteById(int id);

    List<T> findAll();

    T getByUniqueAttribute(String attrName, String value);
}
