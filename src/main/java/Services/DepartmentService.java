package Services;

import HibernateDAO.Implementations.DepartmentDAO;
import Models.Department;

public class DepartmentService extends GenericService<Department> {
    public DepartmentService(){
        super(new DepartmentDAO(), Department.class);
    }

    public Department getByName(String title){
        dao.openCurrentSessionWithTransaction();
        Department department = ((DepartmentDAO)dao).findByName(title);
        dao.closeCurrentSessionWithTransaction();
        return department;
    }
}
