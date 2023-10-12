
package Vistas;


import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.swing.MapView;
import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Mapa extends MapView  {
private Map mapa;
//private String nombre;
//private JFrame ventanaMapa;    
   

    public Mapa(String nombre){JFrame ventanaMapa  = new JFrame(nombre);
    setOnMapReadyHandler(new MapReadyHandler(){

@Override
    /*public void setOnMapReadyHandler(MapReadyHandler handler) {
       super.setOnMapReadyHandler(handler ); //To change body of generated methods, choose Tools | Templates.
    }*/
    public void onMapReady(MapStatus estado){
    
        if(estado==MapStatus.MAP_STATUS_OK){
            
           mapa=getMap();
          
           
           MapOptions mo= new MapOptions();
           
           MapTypeControlOptions mt = new MapTypeControlOptions();
           
           mo.setMapTypeControlOptions(mt);
           
           mapa.setOptions(mo);
           mapa.setCenter(new LatLng(-34.9196425,-57.9524231));
           mapa.setZoom(10);
           
           
           
           Marker puntero = new Marker(mapa);           
           puntero.setVisible(true);
           puntero.setPosition(mapa.getCenter());
           puntero.setClickable(true);
           
        }           
        }
    });
               ventanaMapa.add(this,BorderLayout.CENTER);
               ventanaMapa.setSize(700, 700);
               ventanaMapa.setVisible(true);
    }
}
