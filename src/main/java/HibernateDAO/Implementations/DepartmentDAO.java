package HibernateDAO.Implementations;

import Models.Department;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

public class DepartmentDAO extends GenericEntityDao<Department>{
    public DepartmentDAO() {
        super(Department.class);
    }
}
