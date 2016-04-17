package HibernateDAO.Implementations;

import Models.User;
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
                )).uniqueResult();
        return user;
    }

    public User findByLogin(String login){
        return (User)getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq( "login", login ))
                .uniqueResult();
    }

    public ArrayList<User> findAllClients(){
        ArrayList<User> clients = (ArrayList<User>) getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq( "role", "client" ))
                .list();
        return clients;
    }

}
