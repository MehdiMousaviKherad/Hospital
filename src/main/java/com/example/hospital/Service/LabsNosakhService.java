package com.example.hospital.Service;

import com.example.hospital.Model.Labs;
import com.example.hospital.Model.LabsNosakh;
import com.example.hospital.Model.Nosakh;
import com.example.hospital.Repository.LabsNosakhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List ;
@Service
public class LabsNosakhService {
    @Autowired
    private LabsNosakhRepository repository;
    @Autowired
    private NosakhService nosakhService;
    @Autowired
    private LabsService labsService;

    public LabsNosakh saveEntity(Long nosakhId, Long labsId, LabsNosakh labsNosakh) {
        Labs labs = labsService.getById(labsId);
        Nosakh nosakh = nosakhService.getById(nosakhId);
        if (labs == null || nosakh == null) {
            throw new NullPointerException("not found objects");
        }
        labsNosakh.setNosakh(nosakh);
        labsNosakh.setLabs(labs);
        repository.saveEntity(labsNosakh);
        return labsNosakh;
    }
    public LabsNosakh updateEntity(LabsNosakh labsNosakh){
        return repository.updateEntity(labsNosakh);
    }
    public void deleteEntity(Long id){
        repository.deleteById(id);
    }
    public List<LabsNosakh> getAll(){
        return repository.getAll();
    }
    public LabsNosakh getById(Long id){
        return repository.getById(id);
    }
}
