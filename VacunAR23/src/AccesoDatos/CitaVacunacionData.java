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
import java.time.temporal.*;


/**
 *
 * @author carol
 */
public class CitaVacunacionData {
    
    
    private Connection con;
    private CitaVacunacion cita;
    private int mes;
    private ArrayList<CitaVacunacion>lista;
  
    public CitaVacunacionData(){
  con= Conexion.getConexion();
  mes=LocalDate.now().getMonthValue();
  lista = new ArrayList<>();
  }
  
     public void nuevaCita(CitaVacunacion c){  
    
         String sql = "INSERT INTO citaVacunacion(dni, codRefuerzo, FechaHoraCita, centroVacunacion, fechaHoraColoca, dosis,cancelar) VALUES  (?,?,?,?,?,?,?)";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,c.getCiudadano().getDni());
            ps.setInt(2,c.getCodRefuerzo());
            ps.setTimestamp(3,Timestamp.valueOf(c.getFechaHoraCita()));
            ps.setString(4, c.getCentroVacunacion());
            ps.setDate(5,null);
            ps.setInt(6, c.getVacuna().getNroSerieDosis());
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
   
        public void cancelarCitaPorDni(int dni){
        
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
        
        public void citaVacunacionConcretada(int codCita){
           Timestamp fechaHoy=Timestamp.valueOf(LocalDateTime.now());
           String sql="UPDATE citaVacunacion SET fechaHoraColoca=? WHERE codCita=?";
           try{
               PreparedStatement ps=con.prepareStatement(sql);
               ps.setTimestamp(1, fechaHoy);
               ps.setInt(2, codCita);
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
        
        public int vacunacionesDiarias(String centroDeVacunacion){
            LocalDate fecha=LocalDate.now();
            LocalDateTime fComienzo=LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), 00, 00, 00);
            LocalDateTime fFinal=LocalDateTime.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth(), 23, 59, 59);
            Timestamp inicioDia=Timestamp.valueOf(fComienzo);
            Timestamp finalDia=Timestamp.valueOf(fFinal);
            int vacunaciones=0;
            String sql="SELECT centroVacunacion,COUNT(codCita) AS vacunasDiarias FROM citaVacunacion WHERE fechaHoraColoca BETWEEN ? AND ?";
            try{
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,centroDeVacunacion);
                ps.setTimestamp(2,inicioDia);
                ps.setTimestamp(3,finalDia);
                ResultSet rs=ps.executeQuery();
                vacunaciones=rs.getInt("vacunasDiarias");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al acceder a base de datos citaVacunacion "+ex.getMessage());
            }
            return vacunaciones;
        }
        


        public List citasVencidasPorMes(){
        String sql = "SELECT * FROM citaVacunacion WHEREcentroVacunacion = ? AND fechaHoraColoca = null";
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
                lista.add(cita);
                
                if(ChronoUnit.MONTHS.equals(rs.getTimestamp("fechaHoraColoca").toLocalDateTime())){                     
                            lista.forEach((b)->{b.toString();});
                }
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");       
        }
            
            return lista;
        }
     
        
    
        
        public List citasCumplidasPorMes(String centroVacunacion){
        String sql = "SELECT * FROM citaVacunacion WHERE centroVacunacion =? AND cancelar = 0";
        try {
            CitaVacunacion cv= new CitaVacunacion();  
            Vacuna vac = new Vacuna();
            Ciudadano ciudadano = new Ciudadano();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.setString(1,centroVacunacion);
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
                lista.add(cv);
                 if(ChronoUnit.MONTHS.equals(mes)){ 
                lista.forEach((b)->{b.toString();});}
            }
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla citaVacunacion"); 
        
           
        }
     
         return lista;
        }
        
        
public List citasCanceladasPorMes(String centroVacunacion){            
           String sql ="SELECT * FROM citaVacunacion WHERE centroVacunacion = ? AND cancelar = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            CitaVacunacion c = new CitaVacunacion();
            Ciudadano ciudadano = new Ciudadano();
            Vacuna v = new Vacuna();
            ps.setString(1, centroVacunacion);
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
                lista.add(c);
                
                
                lista.forEach((elem)->{elem.toString();});}
           
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la VacunAR23"); 
        }
         
         return lista;   
}
        
        
        
      
}
