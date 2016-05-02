package HibernateDAO.Implementations;

import Models.Department;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

public class DepartmentDAO extends GenericEntityDao<Department>{
    public DepartmentDAO() {
        super(Department.class);
    }

    public Department findByName(String name){
        return (Department) getCurrentSession().createCriteria(Department.class)
                .add(Restrictions.eq( "name", name ))
                .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                .uniqueResult();
    }
}
