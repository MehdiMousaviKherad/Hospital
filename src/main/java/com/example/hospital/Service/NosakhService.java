package com.example.hospital.Service;

import com.example.hospital.Model.Nosakh;
import com.example.hospital.Repository.NosakhRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NosakhService {
    @Autowired
    private NosakhRepository repository;

    public Nosakh saveEntity(Nosakh nosakh) {
        if (nosakh.getDoctor() == null || nosakh.getReception() == null) {
            throw new NullPointerException("field is null");
        }
        return repository.saveEntity(nosakh);
    }

    public Nosakh updateEntity(Nosakh nosakh) {
        return repository.updateEntity(nosakh);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Nosakh> getAll() {
        return repository.getAll();
    }

    public Nosakh getById(Long id) {
        return repository.getById(id);
    }

}
