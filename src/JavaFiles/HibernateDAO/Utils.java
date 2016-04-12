package JavaFiles.HibernateDAO;

import JavaFiles.Models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Utils {
    private static Utils instance = new Utils();

    public static Utils getInstance() {
        return instance;
    }

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;
    private Utils() {
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