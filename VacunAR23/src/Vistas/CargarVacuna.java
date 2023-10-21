/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.VacunaData;
import entidades.Vacuna;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author usuario
 */
public class CargarVacuna extends javax.swing.JPanel {
private LocalDate fecha;
private VacunaData vacdata;
    /**
     * Creates new form NewJPanel
     */
    public CargarVacuna() {
        initComponents();
        vacdata = new VacunaData();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNumSerie = new javax.swing.JTextField();
        jTMarca = new javax.swing.JTextField();
        jTMedida = new javax.swing.JTextField();
        jDateCaducidad = new com.toedter.calendar.JDateChooser();
        jBCargar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("Marca:");

        jLabel4.setText("Medida");

        jLabel5.setText("Fecha de caducidad:");

        jTMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTMarcaActionPerformed(evt);
            }
        });

        jTMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTMedidaActionPerformed(evt);
            }
        });

        jDateCaducidad.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateCaducidadPropertyChange(evt);
            }
        });

        jBCargar.setText("Cargar");
        jBCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Carga de Vacunas");

        jLabel2.setText("Nº de Serie:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTMedida)
                            .addComponent(jTMarca)
                            .addComponent(jTNumSerie)
                            .addComponent(jDateCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                        .addComponent(jBCargar)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBCargar))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMarcaActionPerformed

    private void jTMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMedidaActionPerformed

    private void jBCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargarActionPerformed
        
        VacunaData vd = new VacunaData();
        
        
        
        if(jTNumSerie.getText().isEmpty()||jTMarca.getText().isEmpty()||jTMedida.getText().isEmpty()/*|| fecha==null*/){
           JOptionPane.showInternalMessageDialog(this, "Complete todos los campos");
           return;
        }
        else{
        ArrayList <Vacuna> carVacuna = new ArrayList();
            int numSerie = Integer.parseInt(jTNumSerie.getText()); 
            Double medida = Double.parseDouble(jTMedida.getText());        
            String NroSerieDosis=jTNumSerie.getText();
            String Marca=jTMarca.getText();
            //int dni=Integer.parseInt(jTDNI.getText());
            String Medida=jTMedida.getText();
            LocalDate FechaCaduca=fecha;
            Boolean Coloca=false;
            
              
               // LocalDate FechaCaduca = Integer.parseInt(fecha.getText());
               // Boolean Coloca = Integer.parseInt(Coloca.getText();
            
            Vacuna vacu =new Vacuna(numSerie,Marca,medida,FechaCaduca,Coloca);
        }
 
        
        
        
        /*      if(jTNumSerie.getText().isEmpty() || jTMarca.getText().isEmpty() || jTMedida.getText().isEmpty()||fecha==null){
           JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
           return;
        }else{
    
       
            Vacuna vac = new Vacuna();

                int numSerie = Integer.parseInt(jTNumSerie.getText()); 
                int medida = Integer.parseInt(jTMedida.getText());
                
                if(numSerie>0){
                    vac.setNroSerieDosis(numSerie);
                    vac.setMarca(jTMarca.getText());
                    vac.setMedida(medida);
                    vac.setFechacaduca(fecha);

                }else{
                    jTNumSerie.setText(null);
                    jTMarca.setText(null);
                    jTMedida.setText(null);
                    JOptionPane.showMessageDialog(this, "Ingrese un Numero de Serie válido");
                    return;
                }

        }        */ // TODO add your handling code here:
    }//GEN-LAST:event_jBCargarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jDateCaducidadPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateCaducidadPropertyChange
        if(jDateCaducidad.getDate()!=null){
        fecha= jDateCaducidad.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jDateCaducidadPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBCargar;
    private com.toedter.calendar.JDateChooser jDateCaducidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTMarca;
    private javax.swing.JTextField jTMedida;
    private javax.swing.JTextField jTNumSerie;
    // End of variables declaration//GEN-END:variables
}
