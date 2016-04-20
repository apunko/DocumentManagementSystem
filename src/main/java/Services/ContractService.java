package Services;

import HibernateDAO.Implementations.ContractDao;
import Models.Contract;
import Models.ContractTemplate;
import Models.PayForm;
import Models.User;

import java.util.ArrayList;

public class ContractService extends GenericService<Contract> {
    public ContractService(){
        super(new ContractDao(), Contract.class);
    }

    @Override
    public Contract getById(int id) {
        Contract contract = super.getById(id);
        return contract;
    }

    public ArrayList<PayForm> getPayForms(){
        PayFormService pfService = new PayFormService();
        ArrayList<PayForm> payForms = pfService.getAll();
        return payForms;
    }

    public User[] getClients(){
        UserService userService = new UserService();
        User[] clients = userService.getClients();
        return clients;
    }

    public ArrayList<ContractTemplate> getTemplates(){
        ContractTemplateService contractTemplateService = new ContractTemplateService();
        ArrayList<ContractTemplate> templates = contractTemplateService.getAll();
        return templates;
    }

    public ContractTemplate getTemplateById(int id){
        ContractTemplateService contractTemplateService = new ContractTemplateService();
        ContractTemplate template = contractTemplateService.getById(id);
        return template;
    }

    public User getUserById(int id){
        UserService userService = new UserService();
        User user = userService.getById(id);
        return user;
    }

    public PayForm getPayFormById(int id){
        PayFormService payFormService = new PayFormService();
        PayForm payForm = payFormService.getById(id);
        return payForm;
    }
}