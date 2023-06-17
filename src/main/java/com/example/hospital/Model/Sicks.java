package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Sicks extends BasePo{
    private String name ;
}
