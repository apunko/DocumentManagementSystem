package HibernateDAO.Implementations;

import Models.ContractTemplate;

public class ContractTemplateDao extends GenericEntityDao<ContractTemplate>{
    public ContractTemplateDao() {
        super(ContractTemplate.class);
    }
}