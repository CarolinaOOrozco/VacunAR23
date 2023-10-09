
package vacunar23;

import AccesoDatos.*;
import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;


public class VacunAR23 {
   
    public static void main(String[] args) {
        
      Ciudadano c = new Ciudadano("Juan Rodriguez","juanroodriguez@hotmail.com", "11743823", "-","soldador");
       
      //  CiudadanoData data = new CiudadanoData();

//  data.guardarCiudadano(c);
        
//Laboratorio lab = new Laboratorio(123, "lab","Argentina","pharma lab","Astra Zeneca");

Vacuna v = new Vacuna(5,"Astra Zeneca",0.3, LocalDate.of(2021, Month.MARCH, 15), false);
//
//LaboratorioData data =new LaboratorioData();

//data.nuevoLaboratorio(lab);


//VacunaData data = new VacunaData();

//data.nuevaVacuna(v);

CitaVacunacion cv  =new CitaVacunacion(c, 35,LocalDateTime.of(2021, 12, 21, 18, 30), "Club", LocalDateTime.of(2021,10,12,9,0), v, Boolean.FALSE);

CitaVacunacionData data = new CitaVacunacionData();

data.nuevaCita(cv);
       
    }
}
