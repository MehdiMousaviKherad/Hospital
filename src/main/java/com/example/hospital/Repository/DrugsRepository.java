package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Drugs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugsRepository implements Dao<Drugs> {
    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public Drugs saveEntity(Drugs drugs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(drugs);
        tr.commit();
        return drugs;
    }

    @Override
    public Drugs updateEntity(Drugs drugs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(drugs);
        tr.commit();
        return drugs;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Drugs> query = session.createQuery("delete from Drugs d where d.id =:id", Drugs.class);
        query.setParameter("id", id);
        query.executeUpdate();
        tr.commit();
    }

    @Override
    public List<Drugs> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Drugs> query = session.createQuery("select d from Drugs d", Drugs.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Drugs getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Drugs> query = session.createQuery("select d from Drugs d where d.id = :id", Drugs.class);
        tr.commit();
        return query.getSingleResult();
    }
}
