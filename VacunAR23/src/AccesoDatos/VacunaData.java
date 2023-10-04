
package AccesoDatos;

import entidades.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;

public class VacunaData {
    
    private Connection con=null;
    
    public VacunaData(){
        con=Conexion.getConexion();
    }
    
    public void nuevaVacuna(Vacuna vacuna){
        String sql="INSERT INTO vacuna (nroSerieDosis,marca,medida,fechaCaduca,colocada) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vacuna.getNroSerieDosis());
            ps.setString(2, vacuna.getMarca());
            ps.setDouble(3,vacuna.getMedida());
            ps.setDate(4,Date.valueOf(vacuna.getFechacaduca()));
            ps.setBoolean(5, vacuna.isColocada());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Vacuna agragada con éxito");
            }else{
                 JOptionPane.showMessageDialog(null, "No se pudo añadir vacuna al sistema");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
    }
    
    public Vacuna buscarVacuna(int nroSerieDosis){
        String sql="SELET * FROM vacuna WHERE nroSerieDosis=?";
        Vacuna v =new Vacuna();
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, nroSerieDosis);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                v.setNroSerieDosis(rs.getInt("norSerieDosis"));
                v.setMarca(rs.getString("marca"));
                v.setMedida(rs.getDouble("medida"));
                v.setFechacaduca(rs.getDate("fechaCaduca").toLocalDate());
                v.setColocada(rs.getBoolean("colocada"));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró la vacuna");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
        return v;
    }
    
    public void marcarComoAplicada(int nroSerieDosis){
        String sql="UPDATE vacuna SET colocada=true WHERE vacuna.nroSerieDosis=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, nroSerieDosis);
            int fila=ps.executeUpdate();
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Vacuna actualizada como 'Colocada' ");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo actualizar estado de la vacuna");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
    }
    
    public ArrayList vacunasDisponibles(){
        ArrayList <Vacuna> vacunasDisponibles=new ArrayList();
        String sql="SELECT * FROM vacuna WHERE colocada=false AND fechaCaduca > ?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vacuna v=new Vacuna();
                v.setNroSerieDosis(rs.getInt("nroSerieDosis"));
                v.setMarca(rs.getString("marca"));
                v.setMedida(rs.getDouble("medida"));
                v.setFechacaduca(rs.getDate("fechaCaduca").toLocalDate());
                v.setColocada(rs.getBoolean("colocada"));
                vacunasDisponibles.add(v);
            }
            if(vacunasDisponibles.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay vacunas disponibles");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
        return vacunasDisponibles;
    }
    
    public ArrayList vacunasAplicadas(){
        ArrayList <Vacuna> vacunasAplicadas=new ArrayList();
        String sql="SELECT * FROM vacuna WHERE colocada=true";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vacuna v=new Vacuna();
                v.setNroSerieDosis(rs.getInt("nroSerieDosis"));
                v.setMarca(rs.getString("marca"));
                v.setMedida(rs.getDouble("medida"));
                v.setFechacaduca(rs.getDate("fechaCaduca").toLocalDate());
                v.setColocada(rs.getBoolean("colocada"));
                vacunasAplicadas.add(v);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
        return vacunasAplicadas;
    }
    
    public ArrayList vacunasVencidas(){
        ArrayList <Vacuna> vacunasVencidas=new ArrayList();
        String sql="SELECT * FROM vacuna WHERE fechaCaduca < ? ";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1,Date.valueOf(LocalDate.now()));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Vacuna v=new Vacuna();
                v.setNroSerieDosis(rs.getInt("nroSerieDosis"));
                v.setMarca(rs.getString("marca"));
                v.setMedida(rs.getDouble("medida"));
                v.setFechacaduca(rs.getDate("fechaCaduca").toLocalDate());
                v.setColocada(rs.getBoolean("colocada"));
                vacunasVencidas.add(v);
            }
            if(vacunasVencidas.isEmpty()){
                JOptionPane.showMessageDialog(null, "No hay vacunas vencidas");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a base de datos 'vacuna' "+ex.getMessage());
        }
        return vacunasVencidas;
    }
}
