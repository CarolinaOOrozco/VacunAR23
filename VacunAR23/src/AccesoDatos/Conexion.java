/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author carol
 */
public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/VacunAR23";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection con;
    
    private Conexion(){
        
    }
    
    public  static Connection getConexion(){

    if(con == null){
    
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
         con =DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Error al cargar el driver  "+ ex.getMessage());
      
        }catch(SQLException ex){
     
            JOptionPane.showMessageDialog(null,"Error de conexion a SQL " +ex.getMessage());
        }
    }
    return con;
    }
}
