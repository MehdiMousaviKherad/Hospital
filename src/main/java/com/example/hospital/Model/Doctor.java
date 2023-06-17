package com.example.hospital.Model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import java.util.Set;

@Entity
@Table
@Data
@Named
@RequestScoped
@ManagedBean
public class Doctor extends BasePo {
    private String name ;
    private String lastName;
    private String nationalCode ;
    private String experience ;
    private String education ;
    @OneToMany(mappedBy = "doctor")
    private Set<ReceptionDoctor> receptionDoctors ;

}
