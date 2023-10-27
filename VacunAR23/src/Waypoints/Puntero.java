
package Waypoints;

import Vistas.ciudadanoT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;





public class Puntero extends DefaultWaypoint {
private String centroVacunatorio;
private JButton boton;
private Connection con;

public Puntero(){con=Conexiones.getConexion();}

public Puntero(String centroVacunatorio,  GeoPosition gp){super(gp);this.centroVacunatorio=centroVacunatorio; inicializarBoton();}

public String getcentroVacunatorio(){return centroVacunatorio;}
public void setcentroVacunatorio(String centroVacunatorio){this.centroVacunatorio = centroVacunatorio;}

public JButton getBoton(){return boton;}
public void setBoton(JButton boton){this.boton=boton;}


public void inicializarBoton(){
boton= new Marker(); 
boton.addActionListener(new ActionListener() {
@Override
    

public void actionPerformed(ActionEvent e){ 
        int respuesta=JOptionPane.showConfirmDialog(null, "¿Desea reservar su turno en "+centroVacunatorio+" ?","Gracias por utilizar VacunAR23",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.NO_OPTION){
        return;
        }else{
          ciudadanoT ciudadano = new ciudadanoT();
         
         // ciudadano.jTCentroElegido.addActionListener(this);        
         //  ciudadano.jTCentroElegido.getActionListeners()
          //ciudadano.jTCentroElegido.setActionCommand(boton.getActionCommand());
          
         
          
          
          JOptionPane.showMessageDialog(null, ciudadano);
}
        
}
});
}
}

    