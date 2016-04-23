package Services;

import HibernateDAO.Implementations.ProjectDao;
import Models.Contract;
import Models.Project;
import Models.User;
import Models.Work;

import java.util.ArrayList;
import java.util.Set;

public class ProjectService extends GenericService<Project> {
    public ProjectService(){
        super(new ProjectDao(), Project.class);
    }

    public ArrayList<Contract> getContracts(){
        ContractService contractService = new ContractService();
        return contractService.getAll();
    }

    public ArrayList<User> getEmployees(){
        UserService userService = new UserService();
        return userService.getEmployees();
    }

    public Contract getContractById(int id){
        ContractService contractService = new ContractService();
        return contractService.getById(id);
    }

    public Set<User> getEmployeesByIds(int[] ids){
        UserService userService = new UserService();
        return userService.getUsersByIds(ids);
    }
}
