package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class ReceptionDoctor  extends BasePo{
    @ManyToOne
    @JoinColumn(name = "fkId")
    private Doctor doctor ;
    @ManyToOne
    @JoinColumn(name = "fId")
    private Reception reception ;
}
