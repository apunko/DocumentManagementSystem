package Models;

import Services.UtilsService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="plan_end_date")
    private Date planEndDate;

    @ManyToOne
    @JoinColumn(name="Contract_id")
    private Contract contract;

    @OneToMany(mappedBy="project", fetch = FetchType.EAGER)
    private Set<Work> works;

    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="employee_project", joinColumns=@JoinColumn(name="Project_id"), inverseJoinColumns=@JoinColumn(name="User_id"))
    private Set<User> employees;

    private String stringPlanEndDate;

    private ArrayList<String> employeesFullNames;

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

    public Date getPlanEndDate(){
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<Work> getWorks() {
        return works;
    }

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    public Set<User> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<User> employees) {
        this.employees = employees;
    }

    public String getStringPlanEndDate() {
        return UtilsService.getDateFormat().format(planEndDate);
    }

    public ArrayList<String> getEmployeesFullNames() {
        ArrayList<String> list = new ArrayList<String>();
        for (User employee : employees) {
            list.add(employee.getFullName());
        }
        return list;
    }
}

