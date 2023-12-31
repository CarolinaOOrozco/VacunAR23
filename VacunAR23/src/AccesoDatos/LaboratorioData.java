/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import entidades.Laboratorio;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

/**
 *
 * @author carol
 */
public class LaboratorioData {
private  Connection con=null;
private ArrayList<Laboratorio> labo;
    
public LaboratorioData(){
labo = new ArrayList<>();
con=Conexion.getConexion();
}


public void nuevoLaboratorio(Laboratorio laboratorio){

String sql = "INSERT INTO laboratorio(CUIT,nomLaboratorio, pais, domComercial,marca) VALUES(?,?,?,?,?)";
    try {
       PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       ps.setInt(1, laboratorio.getCuit());
       ps.setString(2, laboratorio.getNomLaboratorio());
       ps.setString(3, laboratorio.getPais());
       ps.setString(4,laboratorio.getDomComercial());
       ps.setString(5,laboratorio.marca());
       ps.executeUpdate();
       ResultSet rs = ps.getGeneratedKeys();
       
       if(rs.next()){laboratorio.setCuit(rs.getInt(1));}

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la base"+ex.getMessage());
    }
    
}

public void eliminarLaboratorioPorCuit(int cuit){
    try {
        String sql = "UPDATE laboratorio SET estado = 0 WHERE cuit = ? ";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(0,cuit);
        int laboratorioEliminado = ps.executeUpdate();
        if(laboratorioEliminado==1){
        JOptionPane.showMessageDialog(null, "Laboratorio eliminado con exito");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");

}
}

public void modificarLaboratorioPorCuit(Laboratorio lab){

    try {
        String sql ="UPDATE laboratorio.nomLaboratorio, laboratorio.pais,laboratorio.domComercial laboratorio.marca SET  = ?,?,?,? WHERE cuit = ?";
        
        PreparedStatement ps=con.prepareStatement(sql);
      
        ps.setString(0,lab.getNomLaboratorio());
        ps.setString(1,lab.getPais());
        ps.setString(2, lab.getDomComercial());
        ps.setString(3,lab.marca());
        ps.setInt(4, lab.getCuit());
        
        int laboratorioModificado = ps.executeUpdate();
        if(laboratorioModificado==1){
        JOptionPane.showMessageDialog(null, "Laboratorio modificado de manera exitosa");
        }
        
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos"+ex.getMessage());
    }


}


public ArrayList<Laboratorio> mostrarLaboratorio(){





String sql = "SELECT * FROM laboratorio";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        Laboratorio laboratorio=new Laboratorio();
        laboratorio.setCuit(rs.getInt("CUIT"));
        laboratorio.setNomLaboratorio(rs.getString("nomLaboratorio"));
        laboratorio.setPais(rs.getString("pais"));
        laboratorio.setDomComercial(rs.getString("domComercial"));
        laboratorio.setMarca(rs.getString("marca"));
        labo.add(laboratorio);
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos"+ex.getMessage());
    }
    
    return labo;
}

}








