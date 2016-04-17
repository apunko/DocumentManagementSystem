package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name="Template_id")
    private int templateId;

    @Column(name="Payform_id")
    private int payFormId;

    @Column(name="User_id")
    private int clientId;

    private ContractTemplate template;
    private User client;
    private PayForm payForm;


    public Contract(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getPayFormId() {
        return payFormId;
    }

    public void setPayFormId(int payformId) {
        this.payFormId = payformId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
}
