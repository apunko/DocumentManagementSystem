package Services;

import HibernateDAO.Implementations.UserDao;
import Models.Department;
import Models.User;
import Models.Work;

import java.util.ArrayList;
import java.util.HashSet;

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

     public ArrayList<User> getClients(){
         dao.openCurrentSessionWithTransaction();
         ArrayList<User> users = ((UserDao)dao).findAllClients();
         dao.closeCurrentSessionWithTransaction();
         return users;
     }

     public ArrayList<User> getEmployees(){
         dao.openCurrentSessionWithTransaction();
         ArrayList<User> employees = ((UserDao)dao).findAllEmployees();
         dao.closeCurrentSessionWithTransaction();
         return employees;
     }

    public HashSet<User> getUsersByIds(int[] ids){
        HashSet<User> users = new HashSet<User>();
        for (int id: ids) {
            users.add(this.getById(id));
        }
        return users;
    }

    public ArrayList<Department> getDepartments(){
        DepartmentService departmentService = new DepartmentService();
        return departmentService.getAll();
    }

    public Department getDepartmentById(int id){
        DepartmentService departmentService = new DepartmentService();
        return departmentService.getById(id);
    }
}