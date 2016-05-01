package Actions;

import Actions.Interfaces.CRUD;
import Models.Department;
import Models.User;
import Services.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

public class UserActions extends ActionSupport implements SessionAware, CRUD {

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
    private UserService service = new UserService();
    private ArrayList<Department> departments;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    private User user;
    private ArrayList<User> users;
    private ArrayList<User> clients;
    private ArrayList<User> employees;

    private SessionMap<String, Object> session;

    public SessionMap<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }

    public String signIn() {
        try {
            User user = service.getByLoginAndPassword(login, password);
            if (user != null){
                setSessionInformation(user);
                return SUCCESS;
            }
            return ERROR;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String signOut(){
        session.invalidate();
        return SUCCESS;
    }

    public String register(){
        return SUCCESS;
    }

    public String signUp(){
        try {
            User user = service.getByLogin(login);
            if (user != null) {
                return ERROR;
            }
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setDepartment(service.getDepartmentById(1));
            service.create(user);
            if (user.getId() > 0){
                setSessionInformation(user);
                return SUCCESS;
            }
            return ERROR;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String add() {
        try {
            departments = service.getDepartments();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String show(){
        try{
            user = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }
    public String edit(){
        try {
            user = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String index() {
        try {
            clients = service.getClients();
            employees = service.getEmployees();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String create(){
        try {
            User newUser = new User();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPosition(position);
            newUser.setRole("employee");
            newUser.setEmail(email);
            newUser.setExperience(experience);
            newUser.setDepartment(service.getDepartmentById(departmentId));
            service.create(newUser);
            this.id = newUser.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String update(){
        try {
            User userToUpdate = service.getById(id);
            userToUpdate.setFirstName(firstName);
            userToUpdate.setLastName(lastName);
            userToUpdate.setExperience(experience);
            userToUpdate.setPosition(position);
            userToUpdate.setEmail(email);
            userToUpdate.setDepartment(service.getDepartmentById(departmentId));
            service.update(userToUpdate);
            this.id = userToUpdate.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String delete(){
        try {
            User user = service.getById(id);
            service.delete(user);
            this.id = user.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    private void setSessionInformation(User user){
        session.put("id", user.getId());
        session.put("login", user.getLogin());
        session.put("role", user.getRole());
        session.put("fullName", user.getFirstName() + " " + user.getLastName());
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

    public ArrayList<User> getClients() {
        return clients;
    }

    public ArrayList<User> getEmployees() {
        return employees;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}
