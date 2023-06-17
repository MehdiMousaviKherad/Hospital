package com.example.hospital.Service;

import com.example.hospital.Model.Sicks;
import com.example.hospital.Repository.SickRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SickService {

    @Autowired
    private SickRepository repository;

    public Sicks saveEntity(Sicks sicks) {
        if (sicks.getName() == null) {
            throw new NullPointerException("field is null");
        }
        return repository.saveEntity(sicks);
    }

    public Sicks updateEntity(Sicks sicks) {
        return repository.updateEntity(sicks);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public List<Sicks> getAll() {
        return repository.getAll();
    }
}
