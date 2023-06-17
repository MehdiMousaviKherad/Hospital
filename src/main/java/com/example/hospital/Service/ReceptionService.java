package com.example.hospital.Service;

import com.example.hospital.Model.Reception;
import com.example.hospital.Repository.ReceptionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionService {
    @Autowired
    private ReceptionRepository repository ;
    public Reception saveEntity(Reception reception){
        if (reception.getType() == null || reception.getDetections() == null ){
            throw new NullPointerException("filed is null");
        }
       return repository.saveEntity(reception);
    }
    public Reception updateReception(Reception reception){
        return repository.updateEntity(reception);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public List<Reception> getAll(){
        return repository.getAll()  ;
    }
    public Reception getById(Long id){
        return repository.getById(id);
    }
}
