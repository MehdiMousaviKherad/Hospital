package com.example.hospital.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table
public class LabsNosakh extends BasePo{
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "labsId")
    private Labs labs ;
    private Date date ;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nosakhId")
    private Nosakh nosakh ;

}
