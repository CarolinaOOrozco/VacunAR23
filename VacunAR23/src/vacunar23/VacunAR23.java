
package vacunar23;

import AccesoDatos.*;
import entidades.*;
import java.sql.Date;
import java.time.LocalDate;


public class VacunAR23 {
   
    public static void main(String[] args) {
        
//        Ciudadano c = new Ciudadano(234,"a","a","a","a","a");
//        
//        CiudadanoData data = new CiudadanoData();
//        
//        data.guardarCiudadano(c);
        
Laboratorio lab = new Laboratorio(123, "lab","Argentina","pharma lab","Sarscov2");

//Vacuna v = new Vacuna(23,"Astra Zeneca",0.3, LocalDate.now(), false);
//
LaboratorioData data =new LaboratorioData();

data.nuevoLaboratorio(lab);


//VacunaData data = new VacunaData();

//data.nuevaVacuna(v);
       
    }
}
