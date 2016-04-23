package Services;

import HibernateDAO.Implementations.ProjectDao;
import Models.Project;

public class ProjectService extends GenericService<Project> {
    public ProjectService(){
        super(new ProjectDao(), Project.class);
    }
}
