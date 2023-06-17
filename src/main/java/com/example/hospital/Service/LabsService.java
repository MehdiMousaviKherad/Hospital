package com.example.hospital.Service;

import com.example.hospital.Model.Labs;
import com.example.hospital.Repository.LabsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabsService {
    @Autowired
    private LabsRepository repository;

    public Labs saveEntity(Labs labs) {
        return repository.saveEntity(labs);
    }

    public Labs updateEntity(Labs labs, Long id) {
        return repository.updateEntity(labs);
    }

    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    public List<Labs> getAll() {
        return repository.getAll();
    }

    public Labs getById(Long id) {
        return repository.getById(id);
    }

}
