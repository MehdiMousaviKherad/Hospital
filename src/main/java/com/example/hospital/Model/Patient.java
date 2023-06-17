package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Patient")
@Data
public class Patient extends BasePo{
    private String name ;
    private String lastName;
    private String nationalId ;
    private String city ;
    private String gender ;
}
