package Actions;


import java.util.ArrayList;
import java.util.Map;

import Actions.Interfaces.CRUD;
import Models.*;
import Services.ContractService;
import Services.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

public class ContractActions extends ActionSupport implements CRUD, SessionAware, Preparable {

    private int id;
    private Date payDate;
    private Date startDate;
    private Date endDate;
    private int paySum;

    private int payFormId;
    private int clientId;
    private int templateId;

    private ArrayList<Contract> contracts = new ArrayList<Contract>();
    private Contract contract;
    private ContractService service = new ContractService();

    private ArrayList<PayForm> payForms;
    private ArrayList<ContractTemplate> templates;
    private ArrayList<User> clients;
    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public String show(){
        try {
            contract = service.getById(id);
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String edit(){
        throw new UnsupportedOperationException("You cannot edit contract");
    }

    public String index() {
        try {
            contracts = service.getAll();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String create(){
        try {
            contract = new Contract();

            contract.setPayDate(payDate);
            contract.setPaySum(paySum);
            contract.setTemplate(service.getTemplateById(templateId));
            contract.setClient(service.getUserById(clientId));
            contract.setPayForm(service.getPayFormById(payFormId));
            contract.setStartDate(startDate);
            contract.setEndDate(endDate);

            Set<ConstraintViolation<Contract>> constraintViolations =
                    validator.validate(contract);

            if (constraintViolations.size() > 0){
                for (ConstraintViolation<Contract> valid : constraintViolations) {
                    addFieldError(valid.getPropertyPath().toString(), valid.getMessage());
                }
                return INPUT;
            }

            service.create(contract);
            this.id = contract.getId();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public String add() {
        try {
            payForms = service.getPayForms();
            templates = service.getTemplates();
            clients = service.getClients();
            return SUCCESS;
        }
        catch (Exception e){
            addActionError(e.getMessage());
            return ERROR;
        }
    }

    public void prepare() throws Exception {
        payForms = service.getPayForms();
        templates = service.getTemplates();
        clients = service.getClients();
        if (contract == null) {
            contract = new Contract();
        }
    }

    public String update(){
        throw new UnsupportedOperationException("You cannot update contract");
    }

    public String delete(){
        throw new UnsupportedOperationException("You cannot delete contract");
    }

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

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ArrayList<PayForm> getPayForms() {
        return payForms;
    }

    public void setPayForms(ArrayList<PayForm> payForms) {
        this.payForms = payForms;
    }

    public ArrayList<ContractTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(ArrayList<ContractTemplate> templates) {
        this.templates = templates;
    }

    public ArrayList<User> getClients() {
        return clients;
    }

    public void setClients(ArrayList<User> clients) {
        this.clients = clients;
    }

    public int getPayFormId() {
        return payFormId;
    }

    public void setPayFormId(int payFormId) {
        this.payFormId = payFormId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public SessionMap<String, Object> getSession() {
        return session;
    }

    private SessionMap<String, Object> session;

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
    }
}
