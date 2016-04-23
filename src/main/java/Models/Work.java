package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="work")
public class Work {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="work_end_date")
    private Date endDate;

    @Column(name="work_start_date")
    private Date startDate;

    @Column(name="resolved")
    private boolean resolved;

    @ManyToOne
    @JoinColumn(name="Project_id")
    private Project project;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="employee_work", joinColumns=@JoinColumn(name="Work_id"), inverseJoinColumns=@JoinColumn(name="User_id"))
    private Set<User> employees;

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
}
