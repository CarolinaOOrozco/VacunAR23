/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author carol
 */
public class MenuAgenteSanitario extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuAgenteSanitario
     */
    public MenuAgenteSanitario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jVacunas = new javax.swing.JMenu();
        jMCargarVacunas = new javax.swing.JMenuItem();
        jMListarVacunas = new javax.swing.JMenuItem();
        jCitas = new javax.swing.JMenu();
        jMConfCitas = new javax.swing.JMenuItem();
        jMListarCitas = new javax.swing.JMenuItem();
        jMDosisDiarias = new javax.swing.JMenuItem();
        jMListarVacxCiudadano = new javax.swing.JMenuItem();
        jMPostergarCitaxFaltante = new javax.swing.JMenuItem();
        jLaboratorios = new javax.swing.JMenu();
        jMListarLabs = new javax.swing.JMenuItem();

        setClosable(true);

        jVacunas.setText("Vacunas");

        jMCargarVacunas.setText("Cargar vacunas");
        jMCargarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCargarVacunasActionPerformed(evt);
            }
        });
        jVacunas.add(jMCargarVacunas);

        jMListarVacunas.setText("Listar vacunas según...");
        jMListarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarVacunasActionPerformed(evt);
            }
        });
        jVacunas.add(jMListarVacunas);

        jMenuBar1.add(jVacunas);

        jCitas.setText("Citas");

        jMConfCitas.setText("Confirmar citas");
        jCitas.add(jMConfCitas);

        jMListarCitas.setText("Listar citas según..");
        jCitas.add(jMListarCitas);

        jMDosisDiarias.setText("Dosis diarias aplicadas");
        jCitas.add(jMDosisDiarias);

        jMListarVacxCiudadano.setText("Listar vacuna según ciudadano");
        jCitas.add(jMListarVacxCiudadano);

        jMPostergarCitaxFaltante.setText("Postergar cita por faltante");
        jCitas.add(jMPostergarCitaxFaltante);

        jMenuBar1.add(jCitas);

        jLaboratorios.setText("Laboratorios");

        jMListarLabs.setText("Listar laboratorios");
        jLaboratorios.add(jMListarLabs);

        jMenuBar1.add(jLaboratorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMCargarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCargarVacunasActionPerformed

    jMenuBar1.removeAll();
    jMenuBar1.repaint();
    CargarVacuna cv = new CargarVacuna();

    cv.setVisible(true);
    
    jMenuBar1.add(cv);
    
    
    
    //jMenuBar1.moveToFront();        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jMCargarVacunasActionPerformed

    private void jMListarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarVacunasActionPerformed
        // TODO add your handling code here:
    jMenuBar1.removeAll();
    jMenuBar1.repaint();
    ListarVacunas lv = new ListarVacunas();

    lv.setVisible(true);
    
    jMenuBar1.add(lv);
    
    }//GEN-LAST:event_jMListarVacunasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jCitas;
    private javax.swing.JMenu jLaboratorios;
    private javax.swing.JMenuItem jMCargarVacunas;
    private javax.swing.JMenuItem jMConfCitas;
    private javax.swing.JMenuItem jMDosisDiarias;
    private javax.swing.JMenuItem jMListarCitas;
    private javax.swing.JMenuItem jMListarLabs;
    private javax.swing.JMenuItem jMListarVacunas;
    private javax.swing.JMenuItem jMListarVacxCiudadano;
    private javax.swing.JMenuItem jMPostergarCitaxFaltante;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jVacunas;
    // End of variables declaration//GEN-END:variables
}
