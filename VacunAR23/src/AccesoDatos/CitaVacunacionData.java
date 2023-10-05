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
        
            String sql = "UPDATE citaVacunacion set estado = 1 Where dni = ?";
            
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
