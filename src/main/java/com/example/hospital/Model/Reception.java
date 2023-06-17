package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class Reception extends BasePo {
    private Date receptionDate ;
    private String type ;
    @OneToMany(mappedBy = "reception")
    private Set<ReceptionDoctor> receptionDoctor ;
    @OneToOne
    private Detections detections ;
}
