package HibernateDAO.Implementations;

import Models.Project;

public class ProjectDao extends GenericEntityDao<Project>{
    public ProjectDao() {
        super(Project.class);
    }
}