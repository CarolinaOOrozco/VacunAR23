/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.LaboratorioData;
import entidades.Laboratorio;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dev0
 */
public class ListaLaboratorio extends javax.swing.JInternalFrame {
private final DefaultTableModel modelo = new DefaultTableModel();
private Connection con;
    /**
     * Creates new form ListaLaboratorio
     */
    public ListaLaboratorio() {
        initComponents();
        cargarCombo();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jCbLaboratorio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Zekton", 1, 16)); // NOI18N
        jLabel1.setText("     Laboratorios");

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

        jCbLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbLaboratorioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Mono", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione la nacionalidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbLaboratorioActionPerformed
       String filtro = "SELECT * FROM laboratorio WHERE NOT pais = null";
        LaboratorioData lab = new LaboratorioData();
    try {
        PreparedStatement ps = con.prepareStatement(filtro);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){lab.mostrarLaboratorio();}             
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(this, "Error en la base de datos");
    }
      

       
    }//GEN-LAST:event_jCbLaboratorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Laboratorio> jCbLaboratorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables

private void cargarCombo(){
  try{  
jCbLaboratorio.addItem(new Laboratorio("--"));
  }catch(NullPointerException ex){JOptionPane.showMessageDialog(this, "Elija una opción válida");}
jCbLaboratorio.addItem(new Laboratorio("Alemania"));
jCbLaboratorio.addItem(new Laboratorio("Estados Unidos"));
jCbLaboratorio.addItem(new Laboratorio("Rusia"));
jCbLaboratorio.addItem(new Laboratorio("China"));
jCbLaboratorio.addItem(new Laboratorio("Inglaterra"));
}
private void armarCabecera(){
modelo.addColumn("nombre");
modelo.addColumn("cuit");
modelo.addColumn("domicilio comercial");
modelo.addColumn("marca");
jTabla.setModel(modelo);

}

public void cargarTabla(Laboratorio laboratorio){
modelo.addRow(new Object[]{laboratorio.getNomLaboratorio(), laboratorio.getCuit(), laboratorio.getDomComercial(),laboratorio.marca()});
}
}
