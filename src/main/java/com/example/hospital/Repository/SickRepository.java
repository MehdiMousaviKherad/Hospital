package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Sicks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SickRepository implements Dao<Sicks> {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public Sicks saveEntity(Sicks sicks) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        session.persist(sicks);
        tr.commit();
        return sicks;
    }

    @Override
    public Sicks updateEntity(Sicks sicks) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        session.merge(sicks);
        tr.commit();
        return sicks;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        Query<Sicks> query = session.createQuery("delete from Sicks s where s.id =:id" , Sicks.class);
        query.setParameter("id" , id);
        query.executeUpdate();
        tr.commit();
    }

    @Override
    public List<Sicks> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction() ;
        Query<Sicks> query =  session.createQuery("select s from Sicks s " , Sicks.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Sicks getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Sicks> query = session.createQuery("select s from Sicks s where s.id =:id",Sicks.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
