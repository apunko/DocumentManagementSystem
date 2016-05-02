package HibernateDAO.Implementations;

import Models.User;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;

public class UserDao extends GenericEntityDao<User> {

    public UserDao( ) {
        super(User.class);
    }

    public User findByLoginAndPassword(String login, String password){

        User user = (User)getCurrentSession().createCriteria(User.class)
                .add(Restrictions.and(
                        Restrictions.eq( "login", login ),
                        Restrictions.eq( "password", password )
                )).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .uniqueResult();
        return user;
    }

    public User findByLogin(String login){
        return (User)getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq( "login", login ))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .uniqueResult();
    }

    public ArrayList<User> findAllClients(){
        ArrayList<User> clients = (ArrayList<User>) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq( "role", "client" ))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
        return clients;
    }

    public ArrayList<User> findAllEmployees(){
        ArrayList<User> employees = (ArrayList<User>) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.or(Restrictions.eq( "role", "employee" ), Restrictions.eq( "role", "manager" )))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .list();
        return employees;
    }
}
