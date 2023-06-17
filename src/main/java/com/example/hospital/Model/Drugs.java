package com.example.hospital.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table
public class Drugs extends BasePo{
    private String name;
    @OneToMany(mappedBy = "drugs")
    private Set<NosakhDrugs> nosakhDrugs ;
}
