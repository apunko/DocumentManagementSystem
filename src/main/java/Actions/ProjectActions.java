package Actions;

import Actions.Interfaces.CRUD;
import Models.Contract;
import Models.Project;
import Models.User;
import Services.ProjectService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.perf.PerfRollup;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ProjectActions extends ActionSupport implements CRUD, SessionAware {

    private int id;
    private String title;
    private String description;
    private Date planEndDate;
    private int contractId;
    private int[] employeeIds;
    private ArrayList<Project> projects;
    private ArrayList<Contract> contracts;
    private ArrayList<User> employees;
    private ProjectService service = new ProjectService();
    private Project project;

    public String add() {
        contracts = service.getContracts();
        employees = service.getEmployees();
        return SUCCESS;
    }

    public String create() {
        project = new Project();

        project.setTitle(title);
        project.setDescription(description);
        project.setPlanEndDate(planEndDate);
        project.setContract(service.getContractById(contractId));
        project.setEmployees(service.getEmployeesByIds(employeeIds));
        service.create(project);
        this.id = project.getId();
        return SUCCESS;
    }

    public String show() {
        project = service.getById(id);
        return SUCCESS;
    }

    public String index() {
        projects = service.getAll();
        return SUCCESS;
    }

    public String update() {
        throw new UnsupportedOperationException("You cannot edit project now");
    }

    public String delete() {
        throw new UnsupportedOperationException("You cannot delete project now");
    }

    public String edit() {
        throw new UnsupportedOperationException("You cannot edit project now");
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public ArrayList<User> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<User> employees) {
        this.employees = employees;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int[] getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(int[] employeeIds) {
        this.employeeIds = employeeIds;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}
