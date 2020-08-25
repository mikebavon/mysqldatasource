package tracom.hibernate.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateHelper {

    private static SessionFactory sessionFactory;

    private static SessionFactory createSessionFactory(){


        Configuration configuration = new Configuration();

        //configuration.configure("hibernate.cfg.xml");

        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/db_datasource?useSSL=false");
        properties.setProperty(Environment.USER, "root");
        properties.setProperty(Environment.PASS, "Okello3477#*");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(TracomAcademy.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserCredential.class);
        configuration.addAnnotatedClass(Lecturer.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(School.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null)
            sessionFactory = createSessionFactory();

        return sessionFactory;
    }
}
