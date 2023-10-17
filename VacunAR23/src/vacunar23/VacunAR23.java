
package vacunar23;

import AccesoDatos.*;
import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;


public class VacunAR23 {
   
    public static void main(String[] args) {
        
     // Ciudadano c = new Ciudadano("Juan Rodriguez","juanroodriguez@hotmail.com", "11743823", "-","soldador");
       
      //  CiudadanoData data = new CiudadanoData();

//  data.guardarCiudadano(c);
        
//Laboratorio lab = new Laboratorio(123, "lab","Argentina","pharma lab","Astra Zeneca");

//Vacuna v = new Vacuna(5,"Astra Zeneca",0.3, LocalDate.of(2021, Month.MARCH, 15), false);
//
//LaboratorioData data =new LaboratorioData();

//data.nuevoLaboratorio(lab);


//VacunaData data = new VacunaData();

//data.nuevaVacuna(v);

//CitaVacunacion cv  =new CitaVacunacion(c, 35,LocalDateTime.of(2021, 12, 21, 18, 30), "Club",   Boolean.FALSE);

CitaVacunacionData data = new CitaVacunacionData();
//
//data.nuevaCita(cv);



//Mapa2 map = new Mapa2("test");
//map.paint(map.getGraphics());

//data.horarioTurnos();

//data.nuevaCita(cv);

        System.out.println(data.getFechaDeHoy());
        //data.setFechaDeHoy(data.getFechaDeHoy().plusDays(1));
        System.out.println(data.getFechaDeHoy());
        //data.cargarTurnos();
        System.out.println(data.getTurnos());
       

    }
    
}
