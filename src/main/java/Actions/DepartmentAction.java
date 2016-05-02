package Actions;


import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import Actions.Interfaces.CRUD;
import Models.Department;
import Models.User;
import Models.Work;
import Services.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class DepartmentAction extends ActionSupport implements CRUD, SessionAware, Preparable {

    private int id;
    private String name;
    private String description;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private Department department;
    private DepartmentService service = new DepartmentService();
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public String show(){
        try {
            department = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }
    public String edit(){
        try {
            department = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String index() {
        try {
            departments = service.getAll();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String create(){
        try {
            department = new Department();
            department.setName(name);
            department.setDescription(description);

            Set<ConstraintViolation<Department>> constraintViolations =
                    validator.validate(department);

            if (constraintViolations.size() > 0){
                for (ConstraintViolation<Department> valid : constraintViolations) {
                    addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
                }
                return INPUT;
            }
            if (service.getByName(name) != null) {
                addFieldError("name", "Must be unique");
                return INPUT;
            }

            service.create(department);
            this.id = department.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String update(){
        try {
            department = service.getById(id);
            department.setName(name);
            department.setDescription(description);
            Set<ConstraintViolation<Department>> constraintViolations =
                    validator.validate(department);

            if (constraintViolations.size() > 0){
                for (ConstraintViolation<Department> valid : constraintViolations) {
                    addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
                }
                return INPUT;
            }
            if (service.getByName(name) != null) {
                addFieldError("name", "Must be unique");
                return INPUT;
            }

            service.update(department);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String delete(){
        Department dep = service.getById(id);
        service.delete(dep);
        this.id = dep.getId();
        return SUCCESS;
    }

    public String add() {
        return SUCCESS;
    }

    public void prepare() throws Exception {
        if (department == null) {
            department = new Department();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Department> getDepartments(){
        return  departments;
    }

    public Department getDepartment(){
        return  department;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}