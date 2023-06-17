package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table
@Data
public class Labs extends BasePo{
    private String name ;
    @OneToMany(mappedBy = "labs")
    private Set<LabsNosakh> labsNosakh ;
}
