/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.*;
import entidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carol
 */
public class ConsultarCitas extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form CiudadanoCancelar
     */
    public ConsultarCitas() {
        initComponents();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTDNI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaCitas = new javax.swing.JTable();
        jBPostergar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBBuscar = new javax.swing.JButton();

        jTDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTDNIKeyTyped(evt);
            }
        });

        jLabel1.setText("DNI");

        jTablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaCitas);

        jBPostergar.setText("Postergar");
        jBPostergar.setEnabled(false);

        jBCancelar.setText("Cancelar");
        jBCancelar.setEnabled(false);

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jBPostergar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCancelar)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPostergar)
                    .addComponent(jBCancelar))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDNIKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)
        {
            evt.consume();
        }

        
        if (jTDNI.getText().trim().length() == 8) {
            evt.consume();
            
        }
        
    }//GEN-LAST:event_jTDNIKeyTyped

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        
        borrarFilas();
        if(jTDNI.getText().length()!=8){
            JOptionPane.showMessageDialog(this, "Ingrese número de DNI válido");
            return;
        }else if(jTDNI.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un número de DNI");
            return;
        }else if(jTDNI.getText().charAt(0)=='0'){
            JOptionPane.showMessageDialog(this, "DNI no puede iniciar en 0");
            return;
        }else{
            int dni=Integer.parseInt(jTDNI.getText());
        Ciudadano ciud=new Ciudadano();
        CiudadanoData cd =new CiudadanoData();
        ciud=cd.buscarPorDni(dni);
        if(ciud!=null){
            CitaVacunacionData cv= new CitaVacunacionData();
            ArrayList <CitaVacunacion> citas =new ArrayList();
            citas=cv.citasPorPersona(dni);
            if(citas.size()==0){
                JOptionPane.showMessageDialog(this, "Este ciudadano no tiene citas de vacunación");
            }else{
                for(CitaVacunacion c:citas){
                modelo.addRow(new Object[]{c.getCiudadano().getNombreCompleto(),c.getCiudadano().getDni(),c.getFechaHoraCita(),c.getCentroVacunacion()});
                }
            }
        }else{
            jTDNI.setText(null);
        }
        }
        
        
        
    }//GEN-LAST:event_jBBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBPostergar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDNI;
    private javax.swing.JTable jTablaCitas;
    // End of variables declaration//GEN-END:variables

private void armarCabecera(){
    modelo.addColumn("Nombre y apellido");
    modelo.addColumn("DNI");
    modelo.addColumn("Fecha");
    modelo.addColumn("Centro de vacunación");
    jTablaCitas.setModel(modelo);
    }
private void borrarFilas(){
        int f=jTablaCitas.getRowCount()-1;
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
}
