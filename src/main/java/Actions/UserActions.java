package Actions;

import HibernateDAO.Implementations.UserDao;
import Models.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;

import java.util.ArrayList;
import java.util.Map;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    private User user;
    private ArrayList<User> users;

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }

    public String signIn() {
        UserDao dao = new UserDao();
        User user = dao.findByLoginAndPassword(login, password);
        if (user != null){
            session.put("id", user.getId());
            session.put("login", user.getLogin());
            session.put("role", user.getRole());
            return SUCCESS;
        }
        return ERROR;
    }

    public String signOut(){
        session.invalidate();
        return SUCCESS;
    }

    public String register(){
        return SUCCESS;
    }

    public String signUp(){
        UserDao dao = new UserDao();
        User user = dao.findByLogin(login);
        if (user != null) {
            return ERROR;
        }
        user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        dao.persist(user);
        if (user.getId() > 0){
            session.put("id", user.getId());
            session.put("login", user.getLogin());
            session.put("role", user.getRole());
            return SUCCESS;
        }
        return SUCCESS;
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
