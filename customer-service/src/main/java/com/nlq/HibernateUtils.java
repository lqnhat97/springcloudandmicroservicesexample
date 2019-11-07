package com.nlq;

import com.nlq.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.EventListener;
import java.util.Properties;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public synchronized static SessionFactory getSessionFactory(){
        if (sessionFactory != null){
            try{
                Configuration configuration = new Configuration();
                Properties setting = new Properties();
                setting.put(Environment.DRIVER,"");
                setting.put(Environment.URL,"");
                setting.put(Environment.USER,"");
                setting.put(Environment.PASS,"");
                setting.put(Environment.DIALECT,"");
                setting.put(Environment.SHOW_SQL,"true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

                configuration.setProperties(setting);
                configuration.addAnnotatedClass(Customer.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
