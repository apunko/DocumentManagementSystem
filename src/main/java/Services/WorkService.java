package Services;

import HibernateDAO.Implementations.WorkDao;
import Models.Project;
import Models.User;
import Models.Work;

import java.util.*;

public class WorkService extends GenericService<Work> {
    public WorkService(){
        super(new WorkDao(), Work.class);
    }

    public HashSet<Work> getByIds(int[] ids){
        HashSet<Work> works = new HashSet<Work>();
        for (int id: ids) {
            works.add(this.getById(id));
        }
        return works;
    }

    public Set<User> getEmployeesByIds(int[] ids){
        UserService userService = new UserService();
        return userService.getEmployeesByIds(ids);
    }

    public ArrayList<Project> getProjects(){
        ProjectService projectService = new ProjectService();
        return projectService.getAll();
    }

    public ArrayList<User> getEmployees(){
        UserService userService = new UserService();
        return userService.getEmployees();
    }

    public Project getProjectById(int id){
        ProjectService projectService = new ProjectService();
        return projectService.getById(id);
    }
}
