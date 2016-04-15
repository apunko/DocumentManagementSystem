package HibernateDAO.Implementations;
import HibernateDAO.HibernateUtils;
import Models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends GenericEntityDao<Department>{
    private Department dep = new Department();

    public DepartmentDAO() {
        super(Department.class);
    }

}
