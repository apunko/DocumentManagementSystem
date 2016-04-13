package JavaFiles.HibernateDAO;

import JavaFiles.Models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
    private static HibernateUtils instance = new HibernateUtils();

    public static HibernateUtils getInstance() {
        return instance;
    }

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;
    private HibernateUtils() {
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(JavaFiles.Models.Department.class);
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }
}