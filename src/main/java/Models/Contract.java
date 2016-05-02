package Models;

import Services.UtilsService;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="contract")
public class Contract {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Field is required")
    @Column(name="pay_date")
    private Date payDate;

    @NotNull(message = "Field is required")
    @Column(name="start_date")
    private Date startDate;

    @NotNull(message = "Field is required")
    @Column(name="end_date")
    private Date endDate;

    @NotNull(message = "Field is required")
    @Column(name="pay_sum")
    @Range(min=10, message="Contract sum should be 10+")
    private int paySum;

    @NotNull(message = "Field is required")
    @ManyToOne
    @JoinColumn(name="Template_id")
    private ContractTemplate template;

    @NotNull(message = "Field is required")
    @ManyToOne
    @JoinColumn(name="Payform_id")
    private PayForm payForm;

    @NotNull(message = "Field is required")
    @ManyToOne
    @JoinColumn(name="User_id")
    private User client;

    @OneToMany(mappedBy="contract", fetch = FetchType.EAGER)
    private Set<Project> projects;

    private String stringStartDate;
    private String stringEndDate;
    private String stringPayDate;

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

    public String getStringStartDate() {
        return UtilsService.formatDate(startDate);
    }

    public String getStringEndDate() {
        return UtilsService.formatDate(endDate);
    }

    public String getStringPayDate() {
        return UtilsService.formatDate(payDate);
    }
}
