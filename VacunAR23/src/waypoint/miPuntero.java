
package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import AccesoDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class miPuntero extends DefaultWaypoint {
private String nombre;
private JButton boton;
private Connection con;

public miPuntero(){con=Conexion.getConexion();}

public miPuntero(String nombre,  GeoPosition gp){super(gp);this.nombre=nombre; inicializarBoton();}

public String getNombre(){return nombre;}
public void setNombre(String nombre){this.nombre = nombre;}

public JButton getBoton(){return boton;}
public void setBoton(JButton boton){this.boton=boton;}


private void inicializarBoton(){
boton= new WaypointMarker(); 
boton.addActionListener(new ActionListener() {
@Override
    public void actionPerformed(ActionEvent e) {
             int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea reservar su turno en "+nombre+" ?","Gracias por utilizar VacunAR23",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.NO_OPTION){
        return;
        }else{
            String sql = "INSERT INTO citaVacunacion(centroVacunacion)VALUES(?)";
            PreparedStatement ps;
                 try {
                     ps = con.prepareStatement(sql);
                      ps.executeUpdate();
                      ResultSet rs = ps.getGeneratedKeys();
                      if(rs.next()){JOptionPane.showMessageDialog(null,"Turno confirmado!");}
                 } catch (SQLException | NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos");
                 }
           
            }
    }
});
        }
}

