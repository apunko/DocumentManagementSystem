package Services;

import HibernateDAO.Implementations.ContractDao;
import Models.Contract;
import Models.ContractTemplate;
import Models.PayForm;

public class ContractService extends GenericService<Contract> {
    public ContractService(){
        super(new ContractDao(), Contract.class);
    }

    @Override
    public Contract getById(int id) {
        Contract contract = super.getById(id);
        contract = getFullContract(contract);
        return contract;
    }

    private Contract getFullContract(Contract contract){
        ContractTemplateService service = new ContractTemplateService();
        ContractTemplate template = service.getById(contract.getTemplateId());
        contract.setTemplate(template);
        PayFormService pfService = new PayFormService();
        PayForm payForm = pfService.getById(contract.getPayFormId());
        contract.setPayForm(payForm);
        return contract;
    }
}