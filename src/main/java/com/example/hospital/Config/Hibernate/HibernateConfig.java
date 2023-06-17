package com.example.hospital.Config.Hibernate;

import jakarta.inject.Named;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Named
public class HibernateConfig {

    private SessionFactory sessionFactory ;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                List<Class> list = new ArrayList<>();
                Configuration configuration = new Configuration();
                configuration.setProperties(properties());
                ScanEntities.findAllEntities(list).forEach(configuration::addAnnotatedClass);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Jsf");
        properties.setProperty("hibernate.connection.user", "root");
        properties.setProperty("hibernate.connection.password", "Mehdi.7465");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}