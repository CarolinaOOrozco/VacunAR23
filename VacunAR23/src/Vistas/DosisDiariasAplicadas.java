/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.*;
import entidades.*;
import java.time.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carol
 */
public class DosisDiariasAplicadas extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    private ArrayList <String> centrosVacunacion=new ArrayList();
    private LocalDate fechaElegida;
    
    public boolean inCellEditable(int f,int c){
        return false;
    }
    /**
     * Creates new form DosisDiariasAplicadas
     */
    public DosisDiariasAplicadas() {
        initComponents();
        cargarCabecera();
        centrosVacunacion.addAll(cargarCentrosVacunacion());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jDCFecha = new com.toedter.calendar.JDateChooser();
        jBDAplicadas = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Seleccione una fecha");

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTabla);

        jDCFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDCFechaPropertyChange(evt);
            }
        });

        jBDAplicadas.setText("Listar dosis aplicadas");
        jBDAplicadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDAplicadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jBDAplicadas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBDAplicadas, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDCFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDCFechaPropertyChange
        //borrarFilas();
        try{
            
            if(jDCFecha.getDate()!=null){
            fechaElegida=jDCFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //jBDAplicadas.setEnabled(true);
            jDCFecha.setEnabled(false);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
        }
        
         
        
        
        
    }//GEN-LAST:event_jDCFechaPropertyChange

    private void jBDAplicadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDAplicadasActionPerformed
        try{
            borrarFilas();
            if(jDCFecha.equals(null)){
                JOptionPane.showMessageDialog(this, "Ingrese una fecha válida o complete el campo");
                //jDCFecha.cleanup();
                return;
            }else{
                
                List<CitaVacunacion>citas=new ArrayList();
                CitaVacunacionData cvd=new CitaVacunacionData();
                citas=cvd.citasCumplidasPorMes(fechaElegida.getMonthValue());
                for(String centro:centrosVacunacion){
                    int cantidad=0;
                    for(CitaVacunacion c:citas){
                        if(c.getCentroVacunacion()==centro&&c.getFechaHoraCita().toLocalDate()==fechaElegida){
                            cantidad=cantidad+1;
                        }
                    }
                    modelo.addRow(new Object[]{centro,cantidad});
                }  
                //jBDAplicadas.setEnabled(false);
                jDCFecha.setEnabled(true);
                fechaElegida=null;
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Ingrese una fecha válida");
        }
        
        
        
    }//GEN-LAST:event_jBDAplicadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDAplicadas;
    private com.toedter.calendar.JDateChooser jDCFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables

    public void cargarCabecera(){
        modelo.addColumn("Centro de vacunación");
        modelo.addColumn("Cantidad de dosis aplicadas");
        jTabla.setModel(modelo);
    }
    
    public ArrayList cargarCentrosVacunacion(){
        ArrayList<String> centros=new ArrayList();
        centros.add("Hospital del Norte");
        centros.add("Hospital del Oeste Dr. Atilio Luchini");
        centros.add("Hospital del Sur");
        centros.add("Hospital Ramón Carrillo");
        centros.add("Policlínico");
        return centros;
    }
    
    private void borrarFilas(){
        int f=jTabla.getRowCount()-1;      
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
}
