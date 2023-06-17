package com.example.hospital.Repository;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Model.Doctor;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.faces.bean.ManagedBean;
import javax.net.ssl.SSLServerSocket;
import java.util.List;

@ManagedBean
@Repository
public class DoctorRepository {
    @Inject
    private HibernateConfig hibernateConfig;

    public Doctor saveEntity(Doctor doctor) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.persist(doctor);
        tr.commit();
        return doctor;
    }

    public Doctor updateEntity(Doctor doctor) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.merge(doctor);
        tr.commit();
        return doctor;
    }

    public void deleteEntity(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Doctor> query = session.createQuery("delete  from Doctor d where d.id = :id", Doctor.class);
        query.setParameter("id", id);
        query.executeUpdate();
        tr.commit();

    }

    public Doctor getById(Long id) {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Doctor> query = session.createQuery("select d from Doctor d where d.id = :id", Doctor.class);
        query.setParameter("id", id);
        tr.commit();
        return query.getSingleResult();
    }

    public List<Doctor> getAll() {
        SessionFactory sessionFactory = hibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Query<Doctor> query = session.createQuery("select d from Doctor d ", Doctor.class);
        tr.commit();
        return query.getResultList();
    }

}
