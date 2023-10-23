/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaenjava;

import java.awt.Color;
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

import waypoint.miPuntero;



/**
 *
 * @author dev0
 */
public final class FrameMapa extends javax.swing.JFrame {
private final Set<miPuntero> waypoints =new HashSet<>();

;


        
    public FrameMapa() {
        initComponents();      
        init();
        jBsalir.setBackground(new Color(245,64,163)); jBsalir.setForeground(Color.WHITE);
     
    }

   
   

GeoPosition geo1 = new GeoPosition(-34.923173,-57.9386326);
GeoPosition geo2 = new GeoPosition(-34.9244397,-57.9234835);
GeoPosition geo3 = new GeoPosition(-34.9235698,-57.9844044);
GeoPosition geo4 = new GeoPosition(-34.9067063,-57.9658055);
GeoPosition geo5 = new GeoPosition(-34.8977809,-57.9707956);
GeoPosition geo6 = new GeoPosition(-34.8994704,-57.9630709);
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMap = new org.jxmapviewer.JXMapViewer();
        boton = new javax.swing.JButton();
        escoba = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        boton.setFont(new java.awt.Font("Zekton", 1, 10)); // NOI18N
        boton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pinBoton.png"))); // NOI18N
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(evt);
            }
        });

        escoba.setFont(new java.awt.Font("Zekton", 1, 10)); // NOI18N
        escoba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escobaBoton.png"))); // NOI18N
        escoba.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escobaBoton.png"))); // NOI18N
        escoba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escobaActionPerformed(evt);
            }
        });

        jBsalir.setFont(new java.awt.Font("Zekton", 1, 16)); // NOI18N
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
                .addComponent(boton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 522, Short.MAX_VALUE)
                .addGroup(jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escoba, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jXMapLayout.setVerticalGroup(
            jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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
   
      
    }//GEN-LAST:event_escobaActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea Salir del programa?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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


    
}


           
          

   
         
    


