package Vistas;

import AccesoDatos.VacunaData;
import entidades.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ListarVacunas extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public ListarVacunas() {
        initComponents();
        cargarCabecera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVacunas = new javax.swing.JTable();
        jBDisponibles = new javax.swing.JButton();
        jBVencidas = new javax.swing.JButton();
        jBAplicadas = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Stock de vacunas");

        jTableVacunas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTableVacunas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableVacunas);

        jBDisponibles.setBackground(new java.awt.Color(0, 153, 255));
        jBDisponibles.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBDisponibles.setForeground(new java.awt.Color(255, 255, 255));
        jBDisponibles.setText("Disponibles");
        jBDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDisponiblesActionPerformed(evt);
            }
        });

        jBVencidas.setBackground(new java.awt.Color(0, 153, 255));
        jBVencidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBVencidas.setForeground(new java.awt.Color(255, 255, 255));
        jBVencidas.setText("Vencidas");
        jBVencidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVencidasActionPerformed(evt);
            }
        });

        jBAplicadas.setBackground(new java.awt.Color(0, 153, 255));
        jBAplicadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBAplicadas.setForeground(new java.awt.Color(255, 255, 255));
        jBAplicadas.setText("Aplcadas");
        jBAplicadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAplicadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBDisponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAplicadas)
                        .addGap(53, 53, 53)
                        .addComponent(jBVencidas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1)
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDisponibles)
                    .addComponent(jBVencidas)
                    .addComponent(jBAplicadas))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDisponiblesActionPerformed

        borrarFilas();
        VacunaData vd = new VacunaData();
        List<Vacuna> vacunasDisponibles = new ArrayList();
        vacunasDisponibles = vd.vacunasDisponibles();
        for (Vacuna v : vacunasDisponibles) {
            modelo.addRow(new Object[]{v.getNroSerieDosis(), v.getMarca(), v.getMedida(), v.getFechacaduca()});
        }

    }//GEN-LAST:event_jBDisponiblesActionPerformed

    private void jBAplicadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAplicadasActionPerformed

        borrarFilas();
        VacunaData vd = new VacunaData();
        List<Vacuna> vacunasAplicadas = new ArrayList();
        vacunasAplicadas = vd.vacunasAplicadas();
        for (Vacuna v : vacunasAplicadas) {
            modelo.addRow(new Object[]{v.getNroSerieDosis(), v.getMarca(), v.getMedida(), v.getFechacaduca()});
        }
    }//GEN-LAST:event_jBAplicadasActionPerformed

    private void jBVencidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVencidasActionPerformed

        borrarFilas();
        VacunaData vd = new VacunaData();
        List<Vacuna> vacunasVencidas = new ArrayList();
        vacunasVencidas = vd.vacunasVencidas();
        for (Vacuna v : vacunasVencidas) {
            modelo.addRow(new Object[]{v.getNroSerieDosis(), v.getMarca(), v.getMedida(), v.getFechacaduca()});
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jBVencidasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAplicadas;
    private javax.swing.JButton jBDisponibles;
    private javax.swing.JButton jBVencidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVacunas;
    // End of variables declaration//GEN-END:variables


    private void borrarFilas() {
        int f = jTableVacunas.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void cargarCabecera() {
        modelo.addColumn("N° Serie");
        modelo.addColumn("Marca");
        modelo.addColumn("Medida");
        modelo.addColumn("Fecha de Vencimiento");

        jTableVacunas.setModel(modelo);
    }

}
