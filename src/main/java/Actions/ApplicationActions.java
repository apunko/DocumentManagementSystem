package Actions;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;

import java.util.ArrayList;
import java.util.Map;

public class ApplicationActions  extends ActionSupport {

    private String mainInf = "This is main page";

    public String index() {
        return SUCCESS;
    }

    public String getMainInf() {
        return mainInf;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}
