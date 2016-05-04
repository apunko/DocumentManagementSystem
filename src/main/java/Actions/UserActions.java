package Actions;

import Actions.Interfaces.CRUD;
import Models.Department;
import Models.User;
import Models.Work;
import Services.UserService;
import Services.UtilsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class UserActions extends ActionSupport implements SessionAware, CRUD, Preparable {

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
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

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
            user = service.getByLoginAndPassword(login, UtilsService.getPasswordHash(password));
            if (user != null){
                setSessionInformation(user);
                return SUCCESS;
            }
            addActionError("Invalid Login or password");
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
            user = service.getByUniqueAttribute("login", login);

            if (user != null) {
                addFieldError("login", "Login must be unique");
                return INPUT;
            }
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setPosition("client");
            user.setRole("client");
            user.setDepartment(service.getDepartmentById(14));

            if (!isUserValid(user)){
                return INPUT;
            }
            user.setPassword(UtilsService.getPasswordHash(password));
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
        String result = setUser();
        return result;
    }

    public String edit(){
        String result = setUser();
        departments = service.getDepartments();
        return result;
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
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPosition(position);
            user.setRole("employee");
            user.setEmail(email);
            user.setExperience(experience);
            user.setDepartment(service.getDepartmentById(departmentId));

            if (!isUserValid(user)){
                return INPUT;
            }

            service.create(user);
            this.id = user.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String update(){
        try {
            user = service.getById(id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setExperience(experience);
            user.setPosition(position);
            user.setEmail(email);
            user.setDepartment(service.getDepartmentById(departmentId));

            if (!isUserValid(user)){
                return INPUT;
            }

            service.update(user);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String delete(){
        try {
            user = service.getById(id);
            service.delete(user);
            if (user.getId() == 0){
                addActionMessage("User was deleted!");
                return SUCCESS;
            }
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public void prepare() throws Exception {
        if (user == null){
            user = new User();
        }
        departments = service.getDepartments();
    }

    private void setSessionInformation(User user){
        session.put("id", user.getId());
        session.put("login", user.getLogin());
        session.put("role", user.getRole());
        session.put("fullName", user.getFirstName() + " " + user.getLastName());
    }

    private String setUser(){
        try {
            user = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    private boolean isUserValid(User user){
        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate(user);

        if (constraintViolations.size() > 0){
            for (ConstraintViolation<User> valid : constraintViolations) {
                if (valid.getPropertyPath().toString().equals("department")) {
                    addFieldError("departmentId", valid.getMessage());
                    continue;
                }
                addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
            }
            return false;
        }

        if (service.getByUniqueAttribute("email", email) != null) {
            addFieldError("email", "Must be unique");
            return false;
        }
        return true;
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
