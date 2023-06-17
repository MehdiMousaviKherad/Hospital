package com.example.hospital.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class Nosakh extends BasePo{
    private Date date ;
    @ManyToOne
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "ReceptionId")
    private Reception reception ;
    @OneToMany(mappedBy = "nosakh")
    private Set<LabsNosakh> labsNosakhs ;
    @OneToMany(mappedBy = "nosakh")
    private Set<NosakhDrugs> nosakhDrugs ;
}
