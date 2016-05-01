package Models;

import Services.UtilsService;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="work")
public class Work {
    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Field is required")
    @Size(min = 3, max = 100)
    @Column(name="title")
    private String title;

    @NotNull(message = "Field is required")
    @Size(min = 15, max = 2000)
    @Column(name="description")
    private String description;

    @NotNull(message = "Field is required")
    @Column(name="work_end_date")
    private Date endDate;

    @NotNull(message = "Field is required")
    @Column(name="work_start_date")
    private Date startDate;

    @Column(name="resolved")
    private boolean resolved;

    @NotNull(message = "Project is required.")
    @ManyToOne
    @JoinColumn(name="Project_id")
    private Project project;

    @NotEmpty(message="At least one employee is required")
    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="employee_work", joinColumns=@JoinColumn(name="Work_id"), inverseJoinColumns=@JoinColumn(name="User_id"))
    private Set<User> employees;

    private String stringEndDate;
    private String stringStartDate;

    public int getId() {
        return id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }

    public String getStringEndDate() {
        if (endDate == null) return null;
        return UtilsService.getDateFormat().format(endDate);
    }

    public String getStringStartDate() {
        if (endDate == null) return null;
        return UtilsService.getDateFormat().format(startDate);
    }
}
