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

    public String[] getPayFormTypes(){
        PayFormService pfService = new PayFormService();
        ArrayList<PayForm> payForms = pfService.getAll();
        ArrayList<String> payFormTypes = new ArrayList<String>();
        for (PayForm form : payForms) {
            payFormTypes.add(form.getType());
        }
        return (String[]) payFormTypes.toArray();
    }

    public String[] getClientNames(){
        UserService userService = new UserService();
        ArrayList<User> clients = userService.getClients();
        ArrayList<String> clientNames = new ArrayList<String>();
        for (User client : clients) {
            clientNames.add(client.getFirstName() + client.getLastName());
        }
        return (String[]) clientNames.toArray();
    }

    public String[] getTemplateTitles(){
        ContractTemplateService contractTemplateService = new ContractTemplateService();
        ArrayList<ContractTemplate> templates = contractTemplateService.getAll();
        ArrayList<String> templateTitles = new ArrayList<String>();
        for (ContractTemplate template : templates) {
            templateTitles.add(template.getTitle());
        }
        return (String[]) templateTitles.toArray();
    }
}