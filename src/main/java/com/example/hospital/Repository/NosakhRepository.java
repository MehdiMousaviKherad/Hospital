package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Nosakh;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NosakhRepository implements Dao<Nosakh> {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public Nosakh saveEntity(Nosakh nosakh) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(nosakh);
        tr.commit();
        return nosakh;
    }

    @Override
    public Nosakh updateEntity(Nosakh nosakh) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(nosakh);
        tr.commit();
        return nosakh;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Nosakh> query = session.createQuery("delete from Nosakh n where n.id=:id", Nosakh.class);
        query.executeUpdate();
    }

    @Override
    public List<Nosakh> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Nosakh> query = session.createQuery("select n from Nosakh n" , Nosakh.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Nosakh getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Nosakh> query = session.createQuery("select n from Nosakh n where n.id=:id", Nosakh.class);
        query.setParameter("id", id);
        tr.commit();
        return query.getSingleResult();
    }
}
