package Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;
import com.opensymphony.xwork2.ActionSupport;


public class DepartmentAction extends ActionSupport {

    private int id;
    private String name;
    private String description;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private Department department = null;

    public String show(){
        department = getDepartmentByID(id);
        return SUCCESS;
    }
    public String edit(){
        department = getDepartmentByID(id);
        return SUCCESS;
    }

    public String index() {
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        departments = (ArrayList<Department>) dao.findAll();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String create(){
        Department dep = new Department(id, name, description);
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        dao.persist(dep);
        this.id = dep.getId();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String update(){
        Department dep = new Department(id, name, description);
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        dao.update(dep);
        this.id = dep.getId();
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String delete(){
        Department dep = new Department(id, name, description);
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        dao.delete(dep);
        this.id = dep.getId();
        dao.closeCurrentSessionWithTransaction();
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

    private Department getDepartmentByID(int id){
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        Department department = dao.findById(id);
        dao.closeCurrentSessionWithTransaction();
        return department;
    }
}