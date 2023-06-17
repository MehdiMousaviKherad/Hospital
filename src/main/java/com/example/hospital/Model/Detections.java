package com.example.hospital.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Detections extends BasePo {
    private String description;
    @ManyToOne
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "SickId")
    private Sicks sicks ;
}
