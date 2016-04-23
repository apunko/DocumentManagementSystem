package HibernateDAO.Implementations;

import Models.Department;

public class DepartmentDAO extends GenericEntityDao<Department>{
    public DepartmentDAO() {
        super(Department.class);
    }
}
