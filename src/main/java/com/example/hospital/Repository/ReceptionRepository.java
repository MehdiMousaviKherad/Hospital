package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Reception;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceptionRepository implements Dao<Reception> {
    @Autowired
    private HibernateConfig hibernateConfig ;


    @Override
    public Reception saveEntity(Reception reception) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        session.persist(reception);
        tr.commit();
        return reception;
    }

    @Override
    public Reception updateEntity(Reception reception) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        session.merge(reception);
        tr.commit();
        return reception;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        Query<Reception> query = session.createQuery("delete from Reception r where r.id=:id", Reception.class);
        query.executeUpdate();
    }

    @Override
    public List<Reception> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        Query<Reception> query = session.createQuery("select r from Reception r " , Reception.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Reception getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        Query<Reception> query = session.createQuery("select r from Reception r where r.id = :id", Reception.class);
        query.setParameter("id" , id);
        tr.commit();
        return query.getSingleResult();
    }
}
