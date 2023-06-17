package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.NosakhDrugs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class NosakhDrugsRepository implements Dao<NosakhDrugs> {
    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public NosakhDrugs saveEntity(NosakhDrugs nosakhDrugs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(nosakhDrugs);
        tr.commit();
        return nosakhDrugs;
    }

    @Override
    public NosakhDrugs updateEntity(NosakhDrugs nosakhDrugs) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(nosakhDrugs);
        tr.commit();
        return nosakhDrugs;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<NosakhDrugs> query = session.createQuery("delete  from Nosakh N where n.id = :id", NosakhDrugs.class);
        query.executeUpdate();
        tr.commit();
    }

    @Override
    public List<NosakhDrugs> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<NosakhDrugs> Query = session.createQuery("select N from Nosakh N ", NosakhDrugs.class);
        tr.commit();
        return Query.getResultList();
    }

    @Override
    public NosakhDrugs getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<NosakhDrugs> query = session.createQuery("select N from Nosakh N where n.id = :id", NosakhDrugs.class);
        query.setParameter("id", id);
        tr.commit();
        return query.getSingleResult();
    }
}
