
package AccesoDatos;

import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CiudadanoData {
      private Connection con=null;
    
     public static ArrayList <Ciudadano> ciud;
    
    
     
     public CiudadanoData(){
    
    ciud = new ArrayList<>();
    
    con = Conexion.getConexion();
  
    }
    public void guardarCiudadano(Ciudadano ciudadano){
        
    String insert = "INSERT INTO Ciudadano(dni,nombreCompleto,email,celular,patologia,ambitoTrabajo) "
                              + "Values(?,?,?,?,?,?) ";
                              
        try {
            
            PreparedStatement ps = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1 ,ciudadano.getDni());       
            ps.setString(2,ciudadano.getNombreCompleto());
            ps.setString(3,ciudadano.getEmail());
            ps.setString(4,ciudadano.getCelular());
            ps.setString(5,ciudadano.getPatologia());
            ps.setString(6,ciudadano.setAmbitoTrabajo());
            
            ps.executeUpdate();
            
           
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                
                ciudadano.setDni(rs.getInt(1));
                 
            }
            
         
                 JOptionPane.showMessageDialog(null,"Ciudadano agregado exitosamente");
            
        } catch(SQLException ex) {
     
            JOptionPane.showMessageDialog(null,"Error de conexion " +ex.getMessage());
            
        }
    }
    
    
      public Ciudadano buscarPorDni(int dni){
      
          Ciudadano ciudadano = null;
          
          String sql = "SELECT dni, nombreCompleto, email, celular, patologia, ambitoTrabajo  FROM ciudadano WHERE dni = ?";
          
         
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
           
            
            if(rs.next()){
                
            ciudadano = new Ciudadano();
            ciudadano.setDni(dni);
            ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
            ciudadano.setEmail(rs.getString("email"));
            ciudadano.setCelular(rs.getString("celular"));
            ciudadano.setPatologia(rs.getString("patologia"));
            ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
            
            

            }else{
            JOptionPane.showMessageDialog(null,"Ciudadano no encontrado");
             
                    
            }
            //ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error en la conexion a BD "+ ex.getMessage());

                
                }
        
          return ciudadano;
      }
    
    
      public List listarCiudadano(){
          
           String sql="SELECT * FROM Ciudadano WHERE dni=?"; 
         
    try{
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setDni(rs.getInt("dni"));
            ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
            ciudadano.setEmail(rs.getString("email"));
            ciudadano.setCelular(rs.getString("celular"));
            ciudadano.setPatologia(rs.getString("patologia"));
            ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
            
        }
        ps.close();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudadano"+ex.getMessage());
    }
  
    return ciud;
}
      
     
     
    
}
