/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.CitaVacunacionData;
import AccesoDatos.CiudadanoData;
import Waypoints.Puntero;
import Waypoints.Render;
import entidades.CitaVacunacion;
import entidades.Ciudadano;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author dev0
 */
public final class ciudadanoT extends javax.swing.JInternalFrame {
public final Set<Puntero> waypoints =new HashSet<>();
    /**
     * Creates new form map
     */
    public ciudadanoT() {initComponents(); jBSalir.setBackground(new Color (245,64,163)); jBSalir.setForeground(Color.WHITE); init(); cargarCBFdeRiesgo(); cargarCBTrabajo(); mostrarCentros();}

GeoPosition geo1 = new GeoPosition(-33.2969386,-66.3277915);
GeoPosition geo2 = new GeoPosition(-33.3057368,-66.3422729);
GeoPosition geo3 = new GeoPosition(-33.2825983,-66.3494877);
GeoPosition geo4 = new GeoPosition(-33.3089034,-66.3621297);
GeoPosition geo5 = new GeoPosition(-33.3116352,-66.3174176);


public void mostrarCentros(){
waypoints.add(new Puntero("Policlínico", new GeoPosition(geo1.getLatitude(),geo1.getLongitude())));
waypoints.add(new Puntero("Hospital Ramón Carrillo", new GeoPosition(geo2.getLatitude(),geo2.getLongitude())));
waypoints.add(new Puntero("Hospital Del Norte", new GeoPosition(geo3.getLatitude(),geo3.getLongitude())));
waypoints.add(new Puntero("Hospital Del Oeste Dr. Atilio Luchini", new GeoPosition(geo4.getLatitude(),geo4.getLongitude())));
waypoints.add(new Puntero("Hospital Del Sur", new GeoPosition(geo5.getLatitude(),geo5.getLongitude())));     
inicializarWaypoint();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMap = new org.jxmapviewer.JXMapViewer();
        jBSalir = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLDNI = new javax.swing.JLabel();
        jLfactorDeRiesgo = new javax.swing.JLabel();
        jLTrabajo = new javax.swing.JLabel();
        jLTelefono = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTDNI = new javax.swing.JTextField();
        jComboPatologia = new javax.swing.JComboBox<>();
        jComboTrabajo = new javax.swing.JComboBox<>();
        jTTelefono = new javax.swing.JTextField();
        jTEmail = new javax.swing.JTextField();
        jBSolicitar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jXMap.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jXMap.setPreferredSize(new java.awt.Dimension(800, 800));

        jBSalir.setFont(new java.awt.Font("Zekton", 1, 16)); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXMapLayout = new javax.swing.GroupLayout(jXMap);
        jXMap.setLayout(jXMapLayout);
        jXMapLayout.setHorizontalGroup(
            jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapLayout.createSequentialGroup()
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXMapLayout.setVerticalGroup(
            jXMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXMapLayout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        jLTitulo.setFont(new java.awt.Font("Zekton", 1, 16)); // NOI18N
        jLTitulo.setText("    Solicitar Turno");

        jLNombre.setText("Nombre");

        jLApellido.setText("Apellido");

        jLDNI.setText("DNI");

        jLfactorDeRiesgo.setText("Factor de riesgo");

        jLTrabajo.setText("Trabajo");

        jLTelefono.setText("Telefono");

        jLEmail.setText("Email");

        jBSolicitar.setFont(new java.awt.Font("Zekton", 1, 14)); // NOI18N
        jBSolicitar.setText("Solicitar");
        jBSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSolicitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLTelefono)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLEmail)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLfactorDeRiesgo)
                                                .addComponent(jLDNI)
                                                .addComponent(jLApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLNombre))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLTrabajo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(125, 125, 125)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                        .addComponent(jTApellido)
                                        .addComponent(jTDNI)
                                        .addComponent(jComboPatologia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addComponent(jXMap, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNombre)
                            .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLApellido)
                            .addComponent(jTApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDNI)
                            .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboPatologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLfactorDeRiesgo)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTrabajo)
                    .addComponent(jComboTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEmail)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jBSolicitar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jXMap, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        int respuesta=JOptionPane.showConfirmDialog(this, "¿Desea regresar al menú principal?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(respuesta==JOptionPane.NO_OPTION){
        return;
        }else{
            try {
                setClosed(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ciudadanoT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBSalirActionPerformed

   
    private void jBSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSolicitarActionPerformed
               CitaVacunacionData cvd = new CitaVacunacionData();
    
      String sql = "INSERT INTO Ciudadano, citaVacunacion(Ciudadano.nombreCompleto,Ciudadano.dni,Ciudadano.patologia,Ciudadano.ambitoTrabajo,Ciudadano.celular,Ciudadano.email, citaVacunacion.centroVacunacion)"
              + " VALUES(?,?,?,?,?,?,?)";
    
//      int celular = Integer.parseInt(jTDNI.getText());
//      try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1,jTNombre.getText()+" "+jTApellido.getText());
//        ps.setInt(2, celular);
//        ps.setString(3, (String) jComboPatologia.getSelectedItem());
//        ps.setString(4, (String) jComboTrabajo.getSelectedItem());
//        ps.setString(5, jTTelefono.getText());
//        ps.setString(6, jTEmail.getText());
//    
//        ps.executeUpdate();
//               
//    } catch (SQLException | NullPointerException ex) {
//        JOptionPane.showMessageDialog(this, "Error al acceder a la base de datos");
//    }
//      
        
        if(jTApellido.getText().isEmpty()||jTDNI.getText().isEmpty()||jTEmail.getText().isEmpty()||jTTelefono.getText().isEmpty()){
           JOptionPane.showInternalMessageDialog(this, "Complete todos los campos");
           return;
        }
        ArrayList <CitaVacunacion> citas = new ArrayList();
        citas=cvd.citasPorPersona(Integer.parseInt(jTDNI.getText()));
        if(citas.size()>=1){
            JOptionPane.showMessageDialog(this, "Usted no puede solicitar turno,ya que cuenta con 1 o más dosis");
        }else{
                Puntero p = new Puntero();
            String nombreCompleto=jTNombre.getText()+" "+ jTApellido.getText();
            String email=jTEmail.getText();
            int dni=Integer.parseInt(jTDNI.getText());
            String trabajo=(String)jComboTrabajo.getSelectedItem();
            String patologia=(String)jComboPatologia.getSelectedItem();
            String telefono=jTTelefono.getText();
            String centroVacunatorio=p.getcentroVacunatorio();
            
            
            Ciudadano ciud =new Ciudadano(dni,nombreCompleto,email,telefono,patologia,trabajo);
            CiudadanoData cd=new CiudadanoData();
            cd.guardarCiudadano(ciud);
            LocalDateTime turno;
            if(trabajo.equalsIgnoreCase("OTRO")||patologia.equalsIgnoreCase("NINGUNO")){
                turno=cvd.turnoPara4semanas();
            }else{
                turno=cvd.turnoPara2semanas();
            }
            CitaVacunacion cita=new CitaVacunacion(ciud,1,turno,centroVacunatorio,false);
        }
        
        
    
    }//GEN-LAST:event_jBSolicitarActionPerformed

    private void init(){TileFactoryInfo tfi = new OSMTileFactoryInfo();      
    DefaultTileFactory tf = new DefaultTileFactory(tfi);
    GeoPosition gp = new GeoPosition(-33.2928925,-66.365607); 
    jXMap.setTileFactory(tf);   
    jXMap.setAddressLocation(gp);
    jXMap.setZoom(7);

    
       MouseInputListener mil = new PanMouseInputListener(jXMap);
   jXMap.addMouseListener(mil);                  
   jXMap.addMouseMotionListener(mil);   
   jXMap.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMap));
  JXMapViewer.getDefaultLocale();
    }
  
    private void inicializarWaypoint(){
    WaypointPainter<Puntero> wp = new Render();
    wp.setWaypoints(waypoints);
    jXMap.setOverlayPainter(wp);
        for (Puntero waypoint : waypoints) {
            jXMap.add(waypoint.getBoton());
        }
    }
    private void borrarCentros(){ 
        for (Puntero waypoint : waypoints) {
            jXMap.remove(waypoint.getBoton());
        }
    waypoints.clear();
        inicializarWaypoint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBSolicitar;
    private javax.swing.JComboBox<String> jComboPatologia;
    private javax.swing.JComboBox<String> jComboTrabajo;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLDNI;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLTrabajo;
    private javax.swing.JLabel jLfactorDeRiesgo;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDNI;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTTelefono;
    private org.jxmapviewer.JXMapViewer jXMap;
    // End of variables declaration//GEN-END:variables

    public void cargarCBTrabajo(){
    try{
    jComboTrabajo.addItem("--");
    }catch(NullPointerException ex){JOptionPane.showMessageDialog(this,"Ingrese una opción válida");}
    jComboTrabajo.addItem("SALUD");
    jComboTrabajo.addItem("EDUCACIÓN");
    jComboTrabajo.addItem("SEGURIDAD");
    jComboTrabajo.addItem("COMERCIO");
    jComboTrabajo.addItem("OTRO");
}
 
    public void cargarCBFdeRiesgo(){
    try{
    jComboPatologia.addItem("--");
    }catch(NullPointerException ex){JOptionPane.showMessageDialog(this,"Ingrese una opción válida");}
    jComboPatologia.addItem("OBESIDAD");
    jComboPatologia.addItem("HIPERTENSIÓN");
    jComboPatologia.addItem("DIABÉTES");
    jComboPatologia.addItem("EPOC");
    jComboPatologia.addItem("MAYOR DE 65 AÑOS");
    jComboPatologia.addItem("NINGUNO");
}

public WaypointPainter cargarWaypoints(){
   Puntero p = new Puntero();

    for (Puntero waypoint : waypoints) {
       if(waypoints.equals().p.inicializarBoton()){
        waypoints.add(waypoint);
        break;
    }
    }
return p;
}
}
