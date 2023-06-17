package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class NosakhDrugs  extends BasePo{
    @ManyToOne
    @JoinColumn
    private Nosakh nosakh ;
    @ManyToOne
    @JoinColumn
    private Drugs drugs ;
    private String number ;
}
