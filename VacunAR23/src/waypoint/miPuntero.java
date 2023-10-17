
package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;


public class miPuntero extends DefaultWaypoint {
private String nombre;
private JButton boton;


public miPuntero(){}

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
        System.out.println("CLICK: "+nombre);
    }
});
        }
}

