package com.example.hospital.Service;

import com.example.hospital.Model.Drugs;
import com.example.hospital.Repository.DrugsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.faces.bean.ManagedBean;

@Service
@ManagedBean
public class DrugsService {
    @Autowired
    private DrugsRepository repository;

    public Drugs saveDrugs(Drugs drugs) {
        if (drugs.getName() == null) {
            throw new NullPointerException();
        }
        return repository.saveEntity(drugs);
    }

    public Drugs upateDrugs(Drugs drugs, Long id) {
        return repository.updateEntity(drugs);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Drugs> getAll() {
        return repository.getAll();
    }

}
