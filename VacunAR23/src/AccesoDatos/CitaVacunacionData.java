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
    private List<CitaVacunacion>lista;
    private ArrayList<CitaVacunacion> totalCitas;
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
        totalCitas=todasLasCitas();
  }
  
     public void nuevaCita(CitaVacunacion c){  
         
         String sql = "INSERT INTO citavacunacion(dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, dosis,cancelar) VALUES (?,?,?,?,?,?,?)";
         
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
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos"+ex.getMessage());
        }
     }
   
        public void cancelarCitaPorDni(LocalDateTime fecha,int dni,int codCita){
        
            if(fecha.isBefore(LocalDateTime.now())){
                JOptionPane.showMessageDialog(null, "La cita no puede cancelarse porque ya expiró");
            }else{
                String sql = "UPDATE citavacunacion set cancelar = 1 Where dni = ? AND codCita=?";
            
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.setInt(2, codCita);
            int resultado  =ps.executeUpdate();
            if(resultado == 1){
            JOptionPane.showMessageDialog(null, "Cita cancelada exitosamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");
        }
            }
        }
        
        public ArrayList todasLasCitas(){
            ArrayList<CitaVacunacion>citas=new ArrayList();
            String sql="SELECT * FROM citavacunacion ORDER BY centroVacunacion";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    VacunaData vd=new VacunaData();
                    CiudadanoData cd=new CiudadanoData();
                    Vacuna v=vd.buscarVacuna(rs.getInt("dosis"));
                    Ciudadano c=cd.buscarPorDni(rs.getInt("dni"));
                    CitaVacunacion cv=new CitaVacunacion();
                    cv.setCentroVacunacion(rs.getString("centroVacunacion"));
                    cv.setCodRefuerzo(rs.getInt("codRefuerzo"));
                    cv.setCodigoCita(rs.getInt("codCita"));
                    cv.setCancelar(rs.getBoolean("cancelar"));
                    cv.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
                    if(rs.getTimestamp("fechaHoraColoca")==null){
                        cv.setFechaHoraColoca(null);
                    }else{
                        cv.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                    }
                    cv.setVacuna(v);
                    cv.setCiudadano(c);
                    citas.add(cv);
                }
            }catch(SQLException ex){
                
            }
            return citas;
        }
        
        public void citaVacunacionConcretada(int codCita,LocalDateTime fechaHora,Vacuna v){
           //Timestamp fechaHoy=Timestamp.valueOf(LocalDateTime.now());
           String sql="UPDATE citavacunacion SET fechaHoraColoca=?,dosis=? WHERE codCita=?";
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
            Timestamp inicioDia=Timestamp.valueOf(LocalDateTime.of(fechaHoy.getYear(), fechaHoy.getMonth(), fechaHoy.getDayOfMonth(), 00, 00, 00));
            Timestamp finalDia=Timestamp.valueOf(LocalDateTime.of(fechaHoy.getYear(), fechaHoy.getMonth(), fechaHoy.getDayOfMonth(), 23, 59, 59));
            
            String sql="SELECT * FROM citavacunacion WHERE centroVacunacion=? AND fechaHoraCita BETWEEN ? AND ? ORDER BY fechaHoraCita";
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
                    if(rs.getTimestamp("fechaHoraColoca")==null){
                        cv.setFechaHoraColoca(null);
                    }else{
                        cv.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());
                    }
                    
                    cv.setCancelar(rs.getBoolean("cancelar"));
                    citasDiarias.add(cv);
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al acceder a base de datos citaVacunacion "+ex.getMessage());
            }
            return citasDiarias;
        }
        


        public List citasVencidasPorMes(int mesDelAnio){
        lista.removeAll(lista);
            for(CitaVacunacion cv:totalCitas){
            if(cv.getFechaHoraCita().getMonthValue()==mesDelAnio&&cv.getFechaHoraColoca()==null&&cv.getCancelar()==false&&cv.getVacuna().getNroSerieDosis()==0&&cv.getFechaHoraCita().toLocalDate().isBefore(LocalDate.now())){
                lista.add(cv);
            }
        }
            return lista;
        }    

           
        
        
        public List citasCumplidasPorMes(int mesDelAnio){
        lista.removeAll(lista);
        for(CitaVacunacion cv:totalCitas){
            if(cv.getFechaHoraCita().getMonthValue()==mesDelAnio&&cv.getCancelar()==false&&cv.getVacuna().getNroSerieDosis()!=0&&cv.getFechaHoraColoca()!=null){
                lista.add(cv);
            }
        }
         return lista;
    }
        
        
    public List citasCanceladasPorMes(int mesDelAnio){            
        lista.removeAll(lista);
            ArrayList<CitaVacunacion>citas=todasLasCitas();
            for(CitaVacunacion cv:totalCitas){
                if(cv.getFechaHoraCita().getMonthValue()==mesDelAnio&&cv.getCancelar()==true){
                    lista.add(cv);
                }
            }    

        return lista;   
    }

        
        public ArrayList citasPorPersona(int dni){
            ArrayList <CitaVacunacion> cantidadCitas=new ArrayList();
            String sql="SELECT * FROM citavacunacion WHERE dni=? ORDER BY fechaHoraCita";
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
        
      
                int i=(int)(Math.random()*10);
                LocalDateTime turnoAsignado=turnos.get(i).plusDays(14);
                if(turnoAsignado.getDayOfWeek().equals(SATURDAY)){
                    turnoAsignado=turnoAsignado.plusDays(2);
                }else if(turnoAsignado.getDayOfWeek().equals(SUNDAY)){
                    turnoAsignado=turnoAsignado.plusDays(1);
                }

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
      
        
        return turnoAsignado;
    }
    
    

        
        
    

}
        

      

