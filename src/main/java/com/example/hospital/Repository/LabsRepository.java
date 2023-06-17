package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Labs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabsRepository implements Dao<Labs> {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public Labs saveEntity(Labs labs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(labs);
        tr.commit();
        return labs;
    }

    @Override
    public Labs updateEntity(Labs labs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(labs);
        tr.commit();
        return labs ;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Labs> query = session.createQuery("delete from Labs l where l.id = :id", Labs.class);
        query.setParameter("id", id);
        query.executeUpdate();
        tr.commit();
    }

    @Override
    public List<Labs> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Labs> query = session.createQuery("select l from Labs l", Labs.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Labs getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Labs> query = session.createQuery("select l from Labs  l where l.id = :id", Labs.class);
        tr.commit();
        return query.getSingleResult();
    }
}
