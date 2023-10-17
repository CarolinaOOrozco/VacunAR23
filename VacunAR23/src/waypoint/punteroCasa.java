
package waypoint;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;


public final class punteroCasa extends DefaultWaypoint {
private String nombre;
private JButton casa;

public punteroCasa(){}

public punteroCasa(String nombre, GeoPosition gp){super(gp);this.nombre = nombre;  inicializarCasa();}

public String getNombre(){return nombre;}
public void setNombre(String nombre){this.nombre=nombre;}

public JButton getCasa(){return casa;}
public void setCasa(JButton casa){this.casa=casa;}


public void inicializarCasa(){
casa = new WaypointMakerCasa();
casa.addActionListener((ActionEvent e) -> {
    System.out.println("Click: "+casa);
});
}
}
