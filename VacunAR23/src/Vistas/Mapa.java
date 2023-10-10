
package Vistas;


import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;
import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Mapa extends MapView  {
private Map mapa;
private String nombre;
private JFrame ventanaMapa;    
   

    public Mapa(String nombre){ventanaMapa  = new JFrame(nombre);}

@Override
    public void setOnMapReadyHandler(MapReadyHandler handler) {
       super.setOnMapReadyHandler(handler ); //To change body of generated methods, choose Tools | Templates.
    }
    public void onMapReady(MapStatus estado){
    
        if(estado==MapStatus.MAP_STATUS_OK){
            
           mapa.getMapTypeId();
          
           
           MapOptions mo= new MapOptions();
           
           MapTypeControlOptions mt = new MapTypeControlOptions();
           
           mo.setMapTypeControlOptions(mt);
           
           mapa.setOptions(mo);
           mapa.setCenter(new LatLng(-34.9196425,-57.9524231));
           mapa.setZoom(10);
           ventanaMapa.add(this,BorderLayout.CENTER);
           ventanaMapa.setSize(700, 700);
           ventanaMapa.setVisible(true);
           
           Marker puntero = new Marker(mapa);           
           puntero.setVisible(true);
           puntero.setPosition(mapa.getCenter());
           puntero.setClickable(true);
           
        }           
        }
    }
