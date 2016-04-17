package HibernateDAO.Implementations;

import Models.User;
import org.hibernate.criterion.Restrictions;

public class UserDao extends GenericEntityDao<User> {

    public UserDao( ) {
        super(User.class);
    }

    public User findByLoginAndPassword(String login, String password){
        return (User)getCurrentSession().createCriteria(User.class)
                .add(Restrictions.and(
                        Restrictions.eq( "login", login ),
                        Restrictions.eq( "password", password )
                )).uniqueResult();
    }

    public User findByLogin(String login){
        return (User)getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq( "login", login ))
                .uniqueResult();
    }

}
