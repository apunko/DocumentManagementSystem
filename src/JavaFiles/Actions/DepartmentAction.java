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

    public String index() {
        String ret = ERROR;

        DepartmentDAO dao = new DepartmentDAO();
        dao.openCurrentSessionWithTransaction();
        departments = dao.findAll();
        Department depOne = dao.findByPK(1);
        dao.closeCurrentSessionWithTransaction();
        /*
        try {
            String URL = "jdbc:mysql://localhost/spp";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "");
            String sql = "SELECT * FROM department";
            PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                description = rs.getString(3);
                Department dep = new Department(id, name, description);
                departments.add(dep);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }*/
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Department> getDepartments(){
        return  departments;
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