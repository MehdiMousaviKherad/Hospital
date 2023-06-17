package com.example.hospital.Service;

import com.example.hospital.Model.Drugs;
import com.example.hospital.Model.Nosakh;
import com.example.hospital.Model.NosakhDrugs;
import com.example.hospital.Repository.NosakhDrugsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NosakhDrugsService {
    @Autowired
    private NosakhDrugsRepository repository ;
    @Autowired
    private NosakhService nosakhService ;
    @Autowired
    private DrugsService drugsService ;
    public NosakhDrugs saveEntity(){

    }

}
