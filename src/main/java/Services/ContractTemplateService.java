package Services;

import HibernateDAO.Implementations.ContractTemplateDao;
import Models.ContractTemplate;

public class ContractTemplateService extends GenericService<ContractTemplate> {
    public ContractTemplateService(){
        super(new ContractTemplateDao(), ContractTemplate.class);
    }
}