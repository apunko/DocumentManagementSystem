package Actions;

import HibernateDAO.Implementations.UserDao;
import Models.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

public class UserActions extends ActionSupport {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String login;
    private String passport;
    private float experience;
    private String position;
    private int departmentId;

    private User user;
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String New() {
        return SUCCESS;
    }

    public String show(){
        user = getUserByID(id);
        return SUCCESS;
    }
    public String edit(){
        user = getUserByID(id);
        return SUCCESS;
    }

    public String index() {
        UserDao dao = new UserDao();
        dao.openCurrentSessionWithTransaction();
        users = (ArrayList<User>) dao.findAll();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String create(){
        User newUser = new User(id, firstName, lastName, role, experience, position, departmentId);
        UserDao dao = new UserDao();
        dao.openCurrentSessionWithTransaction();
        dao.persist(newUser);
        this.id = newUser.getId();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String update(){
        User userToUpdate = getUserByID(id);
        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);
        UserDao dao = new UserDao();
        dao.openCurrentSessionWithTransaction();
        dao.update(userToUpdate);
        this.id = userToUpdate.getId();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String delete(){
        User dep = getUserByID(id);
        UserDao dao = new UserDao();
        dao.openCurrentSessionWithTransaction();
        dao.delete(dep);
        this.id = dep.getId();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    private User getUserByID(int id){
        UserDao dao = new UserDao();
        dao.openCurrentSessionWithTransaction();
        User user = dao.findById(id);
        dao.closeCurrentSessionWithTransaction();
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
