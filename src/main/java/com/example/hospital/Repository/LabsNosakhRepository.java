package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.LabsNosakh;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabsNosakhRepository implements Dao<LabsNosakh> {
    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public LabsNosakh saveEntity(LabsNosakh labsNosakh) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(labsNosakh);
        tr.commit();
        return labsNosakh;
    }

    @Override
    public LabsNosakh updateEntity(LabsNosakh labsNosakh) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(labsNosakh);
        tr.commit();
        return labsNosakh;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<LabsNosakh> query = session.createQuery("delete from LabsNosakh l where l.id =:id ", LabsNosakh.class);
        query.executeUpdate();
    }

    @Override
    public List<LabsNosakh> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<LabsNosakh> query = session.createQuery("select l from LabsNosakh l ", LabsNosakh.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public LabsNosakh getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<LabsNosakh> query = session.createQuery("select l from LabsNosakh l where l.id = :id" , LabsNosakh.class);
        tr.commit();
        return query.getSingleResult();
    }
}
