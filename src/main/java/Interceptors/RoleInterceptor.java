package Interceptors;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Models.User;
import Services.UserService;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;

public class RoleInterceptor extends AbstractInterceptor {
    private List<String> allowedRoles = new ArrayList<String>();
    private List<String> disallowedRoles = new ArrayList<String>();

    public void setAllowedRoles(String roles) {
        this.allowedRoles = stringToList(roles);
    }

    public void setDisallowedRoles(String roles) {
        this.disallowedRoles = stringToList(roles);
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String result = null;
        if (!isAllowed(request, invocation.getAction())) {
            result = handleRejection(invocation, response);
            request.setAttribute("error", "Access denied.");
        } else {
            result = invocation.invoke();
        }
        return result;
    }

    protected List<String> stringToList(String val) {
        if (val != null) {
            String[] list = val.split("[ ]*,[ ]*");
            return Arrays.asList(list);
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    protected boolean isAllowed(HttpServletRequest request, Object action) throws Exception {
        HttpSession session=request.getSession(false);
        boolean result = false;
        String loginRole = null;

        if(session == null) return false;
        int id = (Integer) session.getAttribute("id");
        UserService service = new UserService();
        User user = service.getById(id);
        if (user == null) {
            session.invalidate();
            return false;
        }
        loginRole = user.getRole();

        if (allowedRoles.size() > 0) {
            if(session==null || loginRole==null){
                return result;
            }
            for (String role : allowedRoles) {
                if (role.equalsIgnoreCase(loginRole)) {
                    result = true;
                }
            }
            return result;
        } else if (disallowedRoles.size() > 0) {
            if(session != null || loginRole != null){
                for (String role : disallowedRoles) {
                    if (role.equalsIgnoreCase(loginRole)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected String handleRejection(ActionInvocation invocation,
                                     HttpServletResponse response)
            throws Exception {
        return "error";
    }

}
