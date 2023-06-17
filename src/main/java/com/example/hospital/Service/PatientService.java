package com.example.hospital.Service;

import com.example.hospital.Model.Patient;

import com.example.hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public Patient saveEntity(Patient patient) {
        if (patient.getName() == null || patient.getNationalId() == null || patient.getLastName() == null) {
            throw new NullPointerException("field is empty");
        }
        return repository.saveEntity(patient);
    }

    public Patient updateEntity(Patient patient) {
        return repository.updateEntity(patient);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public List<Patient> getAll() {
        return repository.getAll();
    }

    public Patient getById(Long id) {
        return repository.getById(id);
    }


}
