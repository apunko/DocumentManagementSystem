package HibernateDAO.Implementations;

import Models.User;

public class UserDao extends GenericEntityDao<User> {

    public UserDao( ) {
        super(User.class);
    }
}
