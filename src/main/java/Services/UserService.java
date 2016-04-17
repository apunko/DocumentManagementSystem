package Services;

import HibernateDAO.Implementations.UserDao;
import Models.User;

public class UserService extends GenericService<User> {

    public UserService(){
        super(new UserDao(), User.class);
    }

    public User getByLoginAndPassword(String login, String password){
        dao.openCurrentSessionWithTransaction();
        User user = ((UserDao)dao).findByLoginAndPassword(login, password);
        dao.closeCurrentSessionWithTransaction();
        return user;
    }

    public User getByLogin(String login){
        dao.openCurrentSessionWithTransaction();
        User user = ((UserDao)dao).findByLogin(login);
        dao.closeCurrentSessionWithTransaction();
        return user;
    }
}