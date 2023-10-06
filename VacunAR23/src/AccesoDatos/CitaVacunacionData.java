/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import entidades.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
  public CitaVacunacionData(){
  con= Conexion.getConexion();
  }
  
     public void nuevaCita(CitaVacunacion c){  
    
         String sql = "INSERT INTO citaVacunacion(dni, codRefuerzo, FechaHoraCita, centroVacunacion, fechaHoraColoca, dosis,cancelar) VALUES = ?,?,?,?,?,?,?";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,c.getCiudadano().getDni());
            ps.setInt(2,c.getCodRefuerzo());
            ps.setString(3,c.getFechaHoraCita());
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
            String sql="SELECT cantroVacunacion,COUNT(codCita) AS vacunasDiarias FROM citaVacunacion WHERE fechaHoraColoca BETWEEN ? AND ?";
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
        
        int mes=LocalDate.now().getMonthValue();
     }
