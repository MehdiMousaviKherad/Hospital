package com.example.hospital.Controller;

import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
@Controller
public class DoctorController {
     public String doctorPage(){
         return "doctor" ;
     }
     public String updateDoctor(){
         return "UpdateDoctor";

     }
     public String deleteDoctor(){
         return "DeleteDoctor";

     }
     public String getDoctor(){
         return "GetDoctor";
     }
}
