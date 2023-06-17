package com.example.hospital.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@MappedSuperclass
@Data
public class BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private Date createAt ;
    private Date updatedAt ;
    private String updatedBy  ;
    private String createdBy ;
}
