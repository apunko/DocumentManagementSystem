package Actions;


import java.util.ArrayList;
import java.util.Map;

import Models.*;
import Services.ContractService;
import Services.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import java.util.Date;

public class ContractActions extends ActionSupport {

    private int id;
    private Date payDate;
    private Date startDate;
    private Date endDate;
    private int paySum;
    private int templateId;
    private int payFormId;
    private int clientId;

    private ContractTemplate template;
    private User client;
    private PayForm payForm;

    private ArrayList<Contract> contracts = new ArrayList<Contract>();
    private Contract contract;
    private ContractService service = new ContractService();

    private String[] templateTitles;
    private String[] clientNames;
    private String[] payFormTypes;

    private String payFormType;
    private String clientName;
    private String templateTitle;

    public String show(){
        contract = service.getById(id);
        return SUCCESS;
    }

    public String edit(){
        throw new UnsupportedOperationException("You cannot edit contract");
    }

    public String index() {
        contracts = service.getAll();
        return SUCCESS;
    }

    public String create(){
        contract = new Contract();

        contract.setPayDate(payDate);
        contract.setPaySum(paySum);
        contract.setTemplateId(templateId);
        contract.setClientId(clientId);
        contract.setPayFormId(payFormId);
        contract.setStartDate(startDate);
        contract.setEndDate(endDate);

        service.create(contract);
        this.id = contract.getId();
        return SUCCESS;
    }


    public String New() {
        payFormTypes = service.getPayFormTypes();
        templateTitles = service.getTemplateTitles();
        clientNames = service.getClientNames();
        return SUCCESS;
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

    public void setId(int id){
        this.id = id;
    }

    private SessionMap<String, Object> session;

    public SessionMap<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap<String, Object>) map;
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

    public void setPayFormId(int payFormId) {
        this.payFormId = payFormId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<Contract> contracts) {
        this.contracts = contracts;
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

    public void setPayForm(PayForm payForm) {
        this.payForm = payForm;
    }

    public String[] getTemplateTitles() {
        return templateTitles;
    }

    public void setTemplateTitles(String[] templateTitles) {
        this.templateTitles = templateTitles;
    }

    public String[] getClientNames() {
        return clientNames;
    }

    public void setClientNames(String[] clientNames) {
        this.clientNames = clientNames;
    }

    public String[] getPayFormTypes() {
        return payFormTypes;
    }

    public void setPayFormTypes(String[] payFormTypes) {
        this.payFormTypes = payFormTypes;
    }

    public String getPayFormType() {
        return payFormType;
    }

    public void setPayFormType(String payFormType) {
        this.payFormType = payFormType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTemplateTitle() {
        return templateTitle;
    }

    public void setTemplateTitle(String templateTitle) {
        this.templateTitle = templateTitle;
    }
}