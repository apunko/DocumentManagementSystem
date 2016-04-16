package Actions;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

public class ApplicationActions  extends ActionSupport {

    private String mainInf = "This is main page";

    public String index() {

        return SUCCESS;
    }

    public String getMainInf() {
        return mainInf;
    }
}
