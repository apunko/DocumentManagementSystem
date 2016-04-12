package JavaFiles.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import JavaFiles.HibernateDAO.Implementations.DepartmentDAO;
import JavaFiles.Models.Department;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport {

    private int id;
    private String name;
    private String description;
    private ArrayList<Department> departments = new ArrayList<>();
    private Department department = null;

    public String show(){
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        department = dao.findByPK(id);
        dao.closeCurrentSessionWithTransaction();
        return SUCCESS;
    }

    public String index() {
        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        departments = dao.findAll();
        dao.closeCurrentSessionWithTransaction();
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
}