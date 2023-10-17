/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaenjava;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;
import waypoint.WaypointRender;
import waypoint.WaypointRenderCasa;
import waypoint.miPuntero;
import waypoint.punteroCasa;


/**
 *
 * @author dev0
 */
public final class FrameMapa extends javax.swing.JFrame {
private final Set<miPuntero> waypoints =new HashSet<>();
private final Set<punteroCasa> waypointsCasa = new HashSet<>();
;


        
    public FrameMapa() {
        initComponents();      
        init();
     
    }

   
   

GeoPosition geo1 = new GeoPosition(-34.923173,-57.9386326);
GeoPosition geo2 = new GeoPosition(-34.9244397,-57.9234835);
GeoPosition geo3 = new GeoPosition(-34.9235698,-57.9844044);
GeoPosition geo4 = new GeoPosition(-34.9067063,-57.9658055);
GeoPosition geo5 = new GeoPosition(-34.8977809,-57.9707956);
GeoPosition geo6 = new GeoPosition(-34.8994704,-57.9630709);
GeoPosition hogar;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMap = new org.jxmapviewer.JXMapViewer();
        boton = new javax.swing.JButton();
        escoba = new javax.swing.JButton();
        casa = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton.setFont(new java.awt.Font("Zekton", 1, 10)); // NOI18N
        boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pin2.png"))); // NOI18N
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        escoba.setFont(new java.awt.Font("Zekton", 1, 10)); // NOI18N
        escoba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba.png"))); // NOI18N
        escoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escobaActionPerformed(evt);
            }
        });

        casa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/casaBoton.png"))); // NOI18N
        casa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casaActionPerformed(evt);
            }
        });

        jBsalir.setFont(new java.awt.Font("Zekton", 1, 14)); // NOI18N
        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapLayout = new javax.swing.GroupLayout(jXMap);
        jXMap.setLayout(jXMapLayout);
        jXMapLayout.setHorizontalGroup(
            jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXMapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(casa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addGroup(jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(escoba, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jXMapLayout.setVerticalGroup(
            jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(escoba, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(casa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jBsalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
 
    
   

    private void botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActionPerformed
       waypoints.add(new miPuntero("centroVacunatorio1", new GeoPosition(geo1.getLatitude(),geo1.getLongitude())));
       waypoints.add(new miPuntero("centroVacunatorio2", new GeoPosition(geo2.getLatitude(),geo2.getLongitude())));
       waypoints.add(new miPuntero("centroVacunatorio3", new GeoPosition(geo3.getLatitude(),geo3.getLongitude())));
       waypoints.add(new miPuntero("centroVacunatorio4", new GeoPosition(geo4.getLatitude(),geo4.getLongitude())));
       waypoints.add(new miPuntero("centroVacunatorio5", new GeoPosition(geo5.getLatitude(),geo5.getLongitude())));
       waypoints.add(new miPuntero("centroVacunatorio6", new GeoPosition(geo6.getLatitude(),geo6.getLongitude())));      
       inicializarWaypoint();
       
       
    }//GEN-LAST:event_botonActionPerformed

    private void escobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escobaActionPerformed
      borrarPuntero();
      borrarCasa();
      
    }//GEN-LAST:event_escobaActionPerformed

    private void casaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casaActionPerformed
    try{
    String lat = JOptionPane.showInputDialog("ingrese la latitud");
    String lon = JOptionPane.showInputDialog("ingrese la longitud");
    Double latitud = Double.parseDouble(lat);
    Double longitud = Double.parseDouble(lon);
    hogar = new GeoPosition(latitud,longitud);
    waypointsCasa.add(new punteroCasa("hogar",new GeoPosition(hogar.getLatitude(),hogar.getLongitude())));
    agregarCasa();
    }catch(NullPointerException | NumberFormatException ex){
    JOptionPane.showMessageDialog(this,"No se admiten campos vacios");
    }        
 

     
    }//GEN-LAST:event_casaActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea regresar al menú principal?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.NO_OPTION){
        return;
        }else{
            System.exit(0);
        }
    }//GEN-LAST:event_jBsalirActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton;
    private javax.swing.JButton casa;
    private javax.swing.JButton escoba;
    private javax.swing.JButton jBsalir;
    private org.jxmapviewer.JXMapViewer jXMap;
    // End of variables declaration//GEN-END:variables

    private void init(){TileFactoryInfo tfi = new OSMTileFactoryInfo();      
    DefaultTileFactory tf = new DefaultTileFactory(tfi);
    GeoPosition gp = new GeoPosition(-34.919056, -57.9503485); 
    jXMap.setTileFactory(tf);   
    jXMap.setAddressLocation(gp);
    jXMap.setZoom(6);   
   
   MouseInputListener mil = new PanMouseInputListener(jXMap);
   jXMap.addMouseListener(mil);                  
   jXMap.addMouseMotionListener(mil);   
   jXMap.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMap));
  JXMapViewer.getDefaultLocale();
    }
  
    private void inicializarWaypoint(){
    WaypointPainter<miPuntero> wp = new WaypointRender();
    wp.setWaypoints(waypoints);
    jXMap.setOverlayPainter(wp);
        for (miPuntero waypoint : waypoints) {
            jXMap.add(waypoint.getBoton());
        }
    }
    private void borrarPuntero(){ 
        for (miPuntero waypoint : waypoints) {
            jXMap.remove(waypoint.getBoton());
        }
    waypoints.clear();
        inicializarWaypoint();
    }

    
    private void agregarCasa(){     
     WaypointPainter<punteroCasa> wpc = new WaypointRenderCasa();
     wpc.setWaypoints(waypointsCasa);
    jXMap.setOverlayPainter(wpc);
        for (punteroCasa elem : waypointsCasa) {                   
            jXMap.add(elem.getCasa());  
        }
    }
    private void borrarCasa(){ 
        for (punteroCasa elem : waypointsCasa) {
            jXMap.remove(elem.getCasa());
        }
    waypointsCasa.clear();
        agregarCasa();
    
    }
}


           
          

   
         
    


