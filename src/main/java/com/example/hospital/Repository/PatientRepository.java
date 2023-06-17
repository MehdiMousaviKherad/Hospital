package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Dao.Dao;
import com.example.hospital.Model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository implements Dao<Patient> {

    @Autowired
    private HibernateConfig hibernateConfig;

    @Override
    public Patient saveEntity(Patient patient) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.persist(patient);
        tr.commit();
        return patient;
    }

    @Override
    public Patient updateEntity(Patient patient) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(patient);
        tr.commit();
        return patient;
    }

    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Patient> query = session.createQuery("delete from Patient  p  where p.id = :id", Patient.class);
        query.executeUpdate();

    }

    @Override
    public List<Patient> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Patient> query = session.createQuery("select p from Patient  p ", Patient.class);
        tr.commit();
        return query.getResultList();
    }

    @Override
    public Patient getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Patient> query = session.createQuery("select p from Patient  p where p.id = :id", Patient.class);
        tr.commit();
        return query.getSingleResult();
    }
}
