package Actions;

import Actions.Interfaces.CRUD;
import Models.Project;
import Models.User;
import Models.Work;
import Services.WorkService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class WorkActions extends ActionSupport implements CRUD, SessionAware, Preparable {

    private int id;
    private String title;
    private String description;
    private Date endDate;
    private Date startDate;
    private boolean resolved;
    private int projectId;
    private int[] employeesIds;
    private Project project;
    private ArrayList<User> employees;
    private Work work;
    private ArrayList<Work> works;
    private ArrayList<Project> projects;
    private WorkService service = new WorkService();
    private String errorMessage;
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public String index() {
        try {
            works = service.getAll();
        }
        catch (Exception e){
            errorMessage = e.getMessage();
            return ERROR;
        }
        return SUCCESS;
    }

    public String add() {
        try {
            projects = service.getProjects();
            employees = service.getEmployees();
        }
        catch (Exception e) {
            errorMessage = e.getMessage();
            return  ERROR;
        }
        return SUCCESS;
    }

    public String create() {
        try {
            work = new Work();

            work.setTitle(title);
            work.setDescription(description);
            work.setEndDate(endDate);
            work.setStartDate(startDate);
            work.setProject(service.getProjectById(projectId));
            Set<User> employeesToAdd = service.getEmployeesByIds(employeesIds);
            work.setEmployees(employeesToAdd);

            Set<ConstraintViolation<Work>> constraintViolations =
                    validator.validate(work);

            if (constraintViolations.size() > 0){
                for (ConstraintViolation<Work> valid : constraintViolations) {
                    addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
                }
                return INPUT;
            }
            service.create(work);
            this.id = work.getId();
        }
        catch (Exception e){
            errorMessage = e.getMessage();
            return ERROR;
        }
        return SUCCESS;
    }

    public String show() {
        try {
            work = service.getById(id);
        }
        catch (Exception e){
            errorMessage = e.getMessage();
            return ERROR;
        }
        return SUCCESS;
    }

    public String update() {
        try {
            work = service.getById(id);

            work.setTitle(title);
            work.setDescription(description);
            work.setEndDate(endDate);
            work.setStartDate(startDate);
            work.setProject(service.getProjectById(projectId));
            Set<User> employees = service.getEmployeesByIds(employeesIds);
            work.setEmployees(employees);

            Set<ConstraintViolation<Work>> constraintViolations =
                    validator.validate(work);

            if (constraintViolations.size() > 0){
                for (ConstraintViolation<Work> valid : constraintViolations) {
                    addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
                }
                return INPUT;
            }

            service.update(work);
            return SUCCESS;
        }
        catch (Exception e){
            errorMessage = e.getMessage();
            return ERROR;
        }
    }

    public String delete() {
        try{
            work = service.getById(id);
            service.delete(work);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String edit() {
        try {
            work = service.getById(id);
            projects = service.getProjects();
            employees = service.getEmployees();
            projectId = work.getProject().getId();
            return SUCCESS;
        }
        catch (Exception e)
        {
            errorMessage = e.getMessage();
            return ERROR;
        }
    }

    public void prepare() throws Exception {
        if (work == null){
            if (id != 0){
                work = service.getById(id);
            }
            else {
                work = new Work();
            }
        }
        projects = service.getProjects();
        employees = service.getEmployees();
        if (work.getProject() != null){
            projectId = work.getProject().getId();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int[] getEmployeesIds() {
        return employeesIds;
    }

    public void setEmployeesIds(int[] employeesIds) {
        this.employeesIds = employeesIds;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ArrayList<User> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<User> employees) {
        this.employees = employees;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public ArrayList<Work> getWorks() {
        return works;
    }

    public void setWorks(ArrayList<Work> works) {
        this.works = works;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
