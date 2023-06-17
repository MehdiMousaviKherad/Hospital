package com.example.hospital.Service;

import com.example.hospital.Config.Hibernate.HibernateConfig;
import com.example.hospital.Model.Doctor;
import com.example.hospital.Repository.DoctorRepository;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;

@ManagedBean
@Service
public class DoctorService {

    @Inject
    private DoctorRepository doctorRepository;

    public Doctor saveEntity(Doctor doctor) {
        if (doctor.getEducation() == null || doctor.getName() == null || doctor.getNationalCode() == null || doctor.getExperience() == null) {
            throw new NullPointerException("field is empty");
        }
        return doctorRepository.saveEntity(doctor);
    }

    public Doctor updateEntity(Long id, Doctor doctor) {
        return doctorRepository.updateEntity(doctor);
    }

    public void deleteEntity(Long id) {
        doctorRepository.deleteEntity(id);
    }

    public Doctor getEntity(Long id) {
       return doctorRepository.getById(id);
    }
}
