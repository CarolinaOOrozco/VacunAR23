/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import entidades.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.time.*;
import static java.time.DayOfWeek.*;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author carol
 */
public class CitaVacunacionData {
    
    
    private Connection con;
    private CitaVacunacion cita;
    private int mes;
    private ArrayList<CitaVacunacion>lista;
    private CiudadanoData cd;
    private VacunaData vd;
    private ArrayList <LocalDateTime> turnos = new ArrayList();
    private LocalDateTime fechaDeHoy=LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), 8, 00, 00);
  
    public CitaVacunacionData(){
        con= Conexion.getConexion();
        mes=LocalDate.now().getMonthValue();
        lista = new ArrayList<>();
        turnos.addAll(cargarTurnos());
        vd=new VacunaData();
  }
  
     public void nuevaCita(CitaVacunacion c){  
         
         String sql = "INSERT INTO citaVacunacion(dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, dosis,cancelar) VALUES (?,?,?,?,?,?,?)";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,c.getCiudadano().getDni());
            ps.setInt(2,c.getCodRefuerzo());
            ps.setTimestamp(3,Timestamp.valueOf(c.getFechaHoraCita()));
            ps.setString(4, c.getCentroVacunacion());
            ps.setTimestamp(5,null);
            ps.setInt(6, 0);
            
            ps.setBoolean(7,c.getCancelar());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            
           if(rs.next()){
           JOptionPane.showMessageDialog(null,"Cita creada exitosamente");
           }
     
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
     }
   
        public void cancelarCitaPorDni(LocalDateTime fecha,int dni){
        
            if(fecha.isBefore(LocalDateTime.now())){
                JOptionPane.showMessageDialog(null, "La cita no puede cancelarse porque ya expiró");
            }else{
                String sql = "UPDATE citaVacunacion set cancelar = 1 Where dni = ?";
            
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, dni);
            int resultado  =ps.executeUpdate();
            if(resultado == 1){
            JOptionPane.showMessageDialog(null, "Cita cancelada exitosamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");
        }
            }
            
            
        
        }
        
        public void citaVacunacionConcretada(int codCita,LocalDateTime fechaHora,Vacuna v){
           //Timestamp fechaHoy=Timestamp.valueOf(LocalDateTime.now());
           String sql="UPDATE citaVacunacion SET fechaHoraColoca=?,dosis=? WHERE codCita=?";
           try{
               PreparedStatement ps=con.prepareStatement(sql);
               ps.setTimestamp(1, Timestamp.valueOf(fechaHora));
               ps.setInt(2, v.getNroSerieDosis());
               ps.setInt(3, codCita);
               int filas=ps.executeUpdate();
               if(filas==1){
                   JOptionPane.showMessageDialog(null, "Cita acutalizada exitosamente");
               }else{
                   JOptionPane.showMessageDialog(null,"No se puedo actualizar cita");
               }
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Error al acceder a base de datos citaVacunacion "+ex.getMessage());
           }
        }
        
        public void vacunaAplicada(int nroSerieDosis){
            
            String sql="UPDATE vacuna SET colocada = true WHERE nroSerieDosis=?";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                
                ps.setInt(1, nroSerieDosis);
                int filas=ps.executeUpdate();
                if(filas==1){
                    JOptionPane.showMessageDialog(null, "Vacuna actualizada exitosamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar vacuna");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al acceder a base de datos vacuna "+ex.getMessage());
            }
        }
        
        public ArrayList vacunacionesDiarias(String centroDeVacunacion,LocalDate fechaHoy){
            ArrayList <CitaVacunacion> citasDiarias=new ArrayList();
            //LocalDate fecha=LocalDate.now();
            Timestamp inicioDia=Timestamp.valueOf(LocalDateTime.of(fechaHoy.getYear(), fechaHoy.getMonth(), fechaHoy.getDayOfMonth(), 00, 00, 00));
            Timestamp finalDia=Timestamp.valueOf(LocalDateTime.of(fechaHoy.getYear(), fechaHoy.getMonth(), fechaHoy.getDayOfMonth(), 23, 59, 59));
            
            String sql="SELECT * FROM citaVacunacion WHERE centroVacunacion=? AND fechaHoraCita BETWEEN ? AND ? ORDER BY fechaHoraCita";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,centroDeVacunacion);
                ps.setTimestamp(2,inicioDia);
                ps.setTimestamp(3,finalDia);
                ResultSet rs=ps.executeQuery();
                VacunaData vd=new VacunaData();
                CiudadanoData cd=new CiudadanoData();
                while(rs.next()){ 
                    CitaVacunacion cv=new CitaVacunacion();
                    Ciudadano c=cd.buscarPorDni(rs.getInt("dni"));
                    Vacuna v=vd.buscarVacuna(rs.getInt("dosis"));
                    cv.setCodigoCita(rs.getInt("codCita"));
                    cv.setCodRefuerzo(rs.getInt("codRefuerzo"));
                    cv.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                    cv.setCiudadano(c);
                    cv.setCentroVacunacion(rs.getString("centroVacunacion"));
                    cv.setVacuna(v);
                    cv.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                    cv.setCancelar(rs.getBoolean("cancelar"));
                    citasDiarias.add(cv);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al acceder a base de datos citaVacunacion "+ex.getMessage());
            }
            return citasDiarias;
        }
        


        public List citasVencidasPorMes(int mesDelAnio){  
        String sql = "SELECT *  FROM citaVacunacion WHERE fechaHoraColoca = null AND cancelar=0";
        PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                CitaVacunacion cita = new CitaVacunacion();
                Ciudadano ciudadano = new Ciudadano();
                Vacuna vac = new Vacuna();
                while(rs.next()){               
                cita.setCodigoCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                cita.setCentroVacunacion(rs.getString("centroVacunacion"));
                cita.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                //cita.setVacuna(vac.getNroSerieDosis(rs.getInt("dosis")));
                cita.setVacuna(vac);
                
                //cita.setCiudadano(ciudadano.getDni(rs.getInt("dni"))); 
                cita.setCiudadano(ciudadano);         
                                   
            if(cita.getFechaHoraCita().getMonthValue()==(mesDelAnio)){

                   lista.remove(cita);                    
            }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");       
        }
            
            return lista;
        }    

           
        
        
        public List citasCumplidasPorMes(int mesDelAnio){
        String sql = "SELECT * FROM citaVacunacion WHERE cancelar = 0 AND NOT fechaHoraColoca  = null";
        try {
            CitaVacunacion cv= new CitaVacunacion();  
            Vacuna vac = new Vacuna();
            Ciudadano ciudadano = new Ciudadano();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();         
            while(rs.next()){
                cv.setCodigoCita(rs.getInt("codCita"));
                cv.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cv.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                cv.setCentroVacunacion(rs.getString("centroVacunacion"));
                cv.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                //cv.setVacuna(vac.setNroSerieDosis(rs.getInt("dosis")));
                cv.setVacuna(vac);
                //cv.setCiudadano(ciudadano.setDni(rs.getInt("dni")));
                cv.setCiudadano(ciudadano);
               
                  if(cv.getFechaHoraCita().getMonthValue()==(mesDelAnio)){
                      lista.add(cv);                     
                  }      
            }
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citaVacunacion"); 
        
           
        }
     
         return lista;
        }
        
        
public List citasCanceladasPorMes(int mesDelAnio){            
           String sql ="SELECT * FROM citaVacunacion WHERE fechaHoraCita = ? AND cancelar = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            CitaVacunacion c = new CitaVacunacion();
            Ciudadano ciudadano = new Ciudadano();
            Vacuna v = new Vacuna();
            while(rs.next()){
                c.setCodigoCita(rs.getInt("codCita"));
                c.setCodRefuerzo(rs.getInt("codRefuerzo"));
                c.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                c.setCentroVacunacion(rs.getString("centroVacunacion"));
                c.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
//                c.setVacuna(v.setNroSerieDosis());
//                c.setCiudadano(ciudadano.setDni(rs.getInt("dni")));
                c.setVacuna(v);
                c.setCiudadano(ciudadano);
              
                
                   if(c.getFechaHoraCita().getMonthValue()==(mesDelAnio)){
                      lista.add(c);                     
                  }   
            }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a VacunAR23"); 
        }         
         return lista;   
}

        
        public ArrayList citasPorPersona(int dni){
            ArrayList <CitaVacunacion> cantidadCitas=new ArrayList();
            String sql="SELECT * FROM citaVacunacion WHERE dni=?";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setInt(1, dni);
                ResultSet rs=ps.executeQuery();
                Ciudadano ciudadano =new Ciudadano();
                CiudadanoData ciudD=new CiudadanoData();
                ciudadano=ciudD.buscarPorDni(dni);
                
                while(rs.next()){
                    Vacuna v= new Vacuna();
                    CitaVacunacion citav= new CitaVacunacion();
                    v=vd.buscarVacuna(rs.getInt("dosis"));
                    citav.setVacuna(v);
                    citav.setCiudadano(ciudadano);
                    citav.setCodRefuerzo(rs.getInt("codRefuerzo"));
                    citav.setCancelar(rs.getBoolean("cancelar"));
                    citav.setCodigoCita(rs.getInt("codCita"));
                    citav.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                    if(rs.getTimestamp("fechaHoraColoca")==null){
                        citav.setFechaHoraColoca(null);
                    }else{
                        citav.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                    }
                    
                    citav.setCentroVacunacion(rs.getString("centroVacunacion"));
                    cantidadCitas.add(citav);
                }
            }catch(SQLException ex){
                
            }
            return cantidadCitas;
        }
        
        public ArrayList cargarTurnos(){
            ArrayList<LocalDateTime>turnosCopia=new ArrayList();
            //int minutos=10;
            LocalDateTime t=fechaDeHoy;
            while(t.getHour()<=18){
                turnos.add(t);
                t=t.plusHours(1);
            }
            return turnosCopia;
        }

    public LocalDateTime getFechaDeHoy() {
        return fechaDeHoy;
    }

    public void setFechaDeHoy(LocalDateTime fechaDeHoy) {
        this.fechaDeHoy = fechaDeHoy;
    }

    public ArrayList<LocalDateTime> getTurnos() {
        return turnos;
    }

    public void setTurnos() {
        turnos.removeAll(turnos);
        turnos.addAll(cargarTurnos());
    }

    
    public void postergarCita(LocalDateTime ldt,int codCita){
        //LocalDateTime fechaActualizada=ldt.plusDays(14);
        if(ldt.isBefore(LocalDateTime.now())){
            JOptionPane.showMessageDialog(null, "No puede cancelar su cita porque la fecha de la misma ya expiró");
        }else{
           String sql="UPDATE citaVacunacion SET fechaHoraCita=? WHERE codCita=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(ldt.plusDays(14)));
            ps.setInt(2, codCita);
            int filas=ps.executeUpdate();
            if(filas==1){
                JOptionPane.showMessageDialog(null, "Su cita fue postergada,le enviaremos un mensaje con la nueva fecha y hora");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos citaVacunación "+ex.getMessage());
        } 
        }
        
    }
    
    public LocalDateTime turnoPara2semanas(){
        
        //while(turnoAsignado==null){
            //for(LocalDateTime t:turnos){
                int i=(int)(Math.random()*10);
                LocalDateTime turnoAsignado=turnos.get(i).plusDays(14);
                if(turnoAsignado.getDayOfWeek().equals(SATURDAY)){
                    turnoAsignado=turnoAsignado.plusDays(2);
                }else if(turnoAsignado.getDayOfWeek().equals(SUNDAY)){
                    turnoAsignado=turnoAsignado.plusDays(1);
                }
                //turnoAsignado=turnoAsignado;
                
                /*try{
                String sql="SELECT COUNT(fechaHoraCita) AS citasPorHora FROM citaVacunacion WHERE fechaHoraCita=?";
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.setTimestamp(1, Timestamp.valueOf(t2));
                 ResultSet rs=ps.executeQuery();
                 int turnos=rs.getInt("citasPorHora");
                 if(turnos<12){
                     turnoAsignado=t2;
                     break;
                 }else if(turnos==0){
                     turnoAsignado=t2;
                     break;
                 }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos "+ex.getMessage());
                }
                
            }
            if(turnoAsignado==null){
                setFechaDeHoy(fechaDeHoy.plusDays(1));
                turnos.removeAll(turnos);
                setTurnos();
            }*/
        //}
        return turnoAsignado;
    }
    
    public LocalDateTime turnoPara4semanas(){
        int i=(int)(Math.random()*10);
                LocalDateTime turnoAsignado=turnos.get(i).plusDays(14);
                if(turnoAsignado.getDayOfWeek().equals(SATURDAY)){
                    turnoAsignado=turnoAsignado.plusDays(2);
                }else if(turnoAsignado.getDayOfWeek().equals(SUNDAY)){
                    turnoAsignado=turnoAsignado.plusDays(1);
                }
                //turnoAsignado=turnoAsignado;
                /*try{
                    String sql="SELECT COUNT(fechaHoraCita) AS citasPorHora FROM citaVacunacion WHERE fechaHoraCita=?";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setTimestamp(1, Timestamp.valueOf(t2));
                    ResultSet rs=ps.executeQuery();
                       if(rs.getInt("citasPorHora")<12){
                        turnoAsignado=t2;
                        break;
                    }else if(rs.getInt("citasPorHora")==0){
                     turnoAsignado=t2;
                     break;
                 }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos "+ex.getMessage());
                }
                
            }
            if(turnoAsignado==null){
                setFechaDeHoy(fechaDeHoy.plusDays(1));
                turnos.removeAll(turnos);
                setTurnos();
            }*/
        
        return turnoAsignado;
    }
    
    /*public ArrayList<LocalDateTime> getTurnos() {
        return turnos;
    }*/
        
        
    

}
        
/*
public void horarioTurnos(){
int turno = (int)(Math.random()*21); 
if(turno<8){
   int  turnoMadrugada = turno+8;
    JOptionPane.showMessageDialog(null,"su cita está programada para asistir a las: "+turnoMadrugada+" horas");    
}else{
    JOptionPane.showMessageDialog(null,"su cita está programada para asistir a las: "+turno+" horas"); 
}
}
}
       */ 
      

