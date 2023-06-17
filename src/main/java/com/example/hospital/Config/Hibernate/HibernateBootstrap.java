package com.example.hospital.Config.Hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HibernateBootstrap {
    public void bootStrap(){
        AnnotationConfigApplicationContext conf = new AnnotationConfigApplicationContext(HibernateConfig.class);
    }
}
