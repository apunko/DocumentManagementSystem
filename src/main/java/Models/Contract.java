package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="contract")
public class Contract {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="pay_date")
    private Date payDate;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="pay_sum")
    private int paySum;


    @ManyToOne
    @JoinColumn(name="Template_id")
    private ContractTemplate template;

    @ManyToOne
    @JoinColumn(name="Payform_id")
    private PayForm payForm;


    @ManyToOne
    @JoinColumn(name="User_id")
    private User client;

    @OneToMany(mappedBy="contract", fetch = FetchType.EAGER)
    private Set<Project> projects;

    public Contract(){}

    public int getId() {
        return id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPaySum() {
        return paySum;
    }

    public void setPaySum(int paySum) {
        this.paySum = paySum;
    }

    public ContractTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ContractTemplate template) {
        this.template = template;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public PayForm getPayForm() {
        return payForm;
    }

    public void setPayForm(PayForm payform) {
        this.payForm = payform;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
