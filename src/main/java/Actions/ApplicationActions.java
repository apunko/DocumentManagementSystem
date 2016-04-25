package Actions;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

public class ApplicationActions  extends ActionSupport implements SessionAware {

    private String mainInf = "This is main page";

    public String index() {
        return SUCCESS;
    }

    public String error(){
        return SUCCESS;
    }

    public String getMainInf() {
        return mainInf;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}
