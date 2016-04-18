package Actions;


import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import Models.Department;
import Models.User;
import Services.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;


public class DepartmentAction extends ActionSupport {

    private int id;
    private String name;
    private String description;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private Department department;
    private DepartmentService service = new DepartmentService();

    public String show(){
        department = service.getById(id);
        return SUCCESS;
    }
    public String edit(){
        department = service.getById(id);
        return SUCCESS;
    }

    public String index() {
        departments = service.getAll();
        return SUCCESS;
    }

    public String create(){
        Department dep = new Department(id, name, description);
        service.create(dep);
        this.id = dep.getId();
        return SUCCESS;
    }

    public String update(){
        Department dep = new Department(id, name, description);
        service.update(dep);
        this.id = dep.getId();
        return SUCCESS;
    }

    public String delete(){
        Department dep = new Department(id, name, description);
        service.delete(dep);
        this.id = dep.getId();
        return SUCCESS;
    }

    public String New() {
        return SUCCESS;
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