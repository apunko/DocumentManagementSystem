package Services;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;

public class DepartmentService extends GenericService<Department> {
    public DepartmentService(){
        super(new DepartmentDAO(), Department.class);
    }
}
