/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author carol
 */
public class MenuAgenteSanitario extends javax.swing.JInternalFrame {
    

    
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Desktop1.jpg"));
        Image image = icon.getImage();
        escritorioASanitario =  new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jVacunas = new javax.swing.JMenu();
        jMCargarVacunas = new javax.swing.JMenuItem();
        jMListarVacunas = new javax.swing.JMenuItem();
        jCitas = new javax.swing.JMenu();
        jMConfCitas = new javax.swing.JMenuItem();
        jMListarCitas = new javax.swing.JMenuItem();
        jMDosisDiarias = new javax.swing.JMenuItem();
        jMListarVacxCentro = new javax.swing.JMenuItem();
        jMPostergarCitaxFaltante = new javax.swing.JMenuItem();
        jLaboratorios = new javax.swing.JMenu();
        jMListarLabs = new javax.swing.JMenuItem();
        jMNuevoLab = new javax.swing.JMenuItem();

        setClosable(true);
        setResizable(true);

        javax.swing.GroupLayout escritorioASanitarioLayout = new javax.swing.GroupLayout(escritorioASanitario);
        escritorioASanitario.setLayout(escritorioASanitarioLayout);
        escritorioASanitarioLayout.setHorizontalGroup(
            escritorioASanitarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        escritorioASanitarioLayout.setVerticalGroup(
            escritorioASanitarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jVacunas.setText("Vacunas");

        jMCargarVacunas.setText("Cargar vacunas");
        jMCargarVacunas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMCargarVacunasMouseClicked(evt);
            }
        });
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
        jMConfCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMConfCitasActionPerformed(evt);
            }
        });
        jCitas.add(jMConfCitas);

        jMListarCitas.setText("Listar citas según..");
        jMListarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarCitasActionPerformed(evt);
            }
        });
        jCitas.add(jMListarCitas);

        jMDosisDiarias.setText("Dosis diarias aplicadas");
        jMDosisDiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMDosisDiariasActionPerformed(evt);
            }
        });
        jCitas.add(jMDosisDiarias);

        jMListarVacxCentro.setText("Listar vacunas por centro");
        jMListarVacxCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarVacxCentroActionPerformed(evt);
            }
        });
        jCitas.add(jMListarVacxCentro);

        jMPostergarCitaxFaltante.setText("Postergar cita por faltante");
        jMPostergarCitaxFaltante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMPostergarCitaxFaltanteActionPerformed(evt);
            }
        });
        jCitas.add(jMPostergarCitaxFaltante);

        jMenuBar1.add(jCitas);

        jLaboratorios.setText("Laboratorios");

        jMListarLabs.setText("Listar laboratorios");
        jMListarLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListarLabsActionPerformed(evt);
            }
        });
        jLaboratorios.add(jMListarLabs);

        jMNuevoLab.setText("Nuevo laboratorio");
        jMNuevoLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNuevoLabActionPerformed(evt);
            }
        });
        jLaboratorios.add(jMNuevoLab);

        jMenuBar1.add(jLaboratorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioASanitario)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorioASanitario)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jMCargarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCargarVacunasActionPerformed

        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            CargarVacuna cv = new CargarVacuna();
            cv.setVisible(true);
            escritorioASanitario.add(cv);
            escritorioASanitario.moveToFront(cv);
            escritorioASanitario.setSelectedFrame(cv);
            
        }
            
        
        
    }//GEN-LAST:event_jMCargarVacunasActionPerformed

    private void jMListarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarVacunasActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.removeAll();
            escritorioASanitario.repaint();
            ListarVacunas lv = new ListarVacunas();

            lv.setVisible(true);

            escritorioASanitario.add(lv);
            escritorioASanitario.setSelectedFrame(lv);
        }
        
        
    
    }//GEN-LAST:event_jMListarVacunasActionPerformed

    private void jMConfCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMConfCitasActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            ConfirmarCitas cc= new ConfirmarCitas();
            cc.setVisible(true);
            escritorioASanitario.add(cc);
            escritorioASanitario.moveToFront(cc);
            escritorioASanitario.setSelectedFrame(cc);
        }
        
    }//GEN-LAST:event_jMConfCitasActionPerformed

    private void jMListarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarCitasActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            ListarCitas lc=new ListarCitas();
            lc.setVisible(true);
            escritorioASanitario.add(lc);
            escritorioASanitario.moveToFront(lc);
            escritorioASanitario.setSelectedFrame(lc);
        }
        
    }//GEN-LAST:event_jMListarCitasActionPerformed

    private void jMDosisDiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMDosisDiariasActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            DosisDiariasAplicadas dda=new DosisDiariasAplicadas();
            dda.setVisible(true);
            escritorioASanitario.add(dda);
            escritorioASanitario.moveToFront(dda);
            escritorioASanitario.setSelectedFrame(dda);
        }
        
    }//GEN-LAST:event_jMDosisDiariasActionPerformed


    private void jMListarVacxCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarVacxCentroActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            ListadoVacunasPorCentro lvc=new ListadoVacunasPorCentro();
            lvc.setVisible(true);
            escritorioASanitario.add(lvc);
            escritorioASanitario.moveToFront(lvc);
            escritorioASanitario.setSelectedFrame(lvc);
        }
        
    }//GEN-LAST:event_jMListarVacxCentroActionPerformed

    private void jMPostergarCitaxFaltanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMPostergarCitaxFaltanteActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            PostergarCitaXFaltante pcf=new PostergarCitaXFaltante();
            pcf.setVisible(true);
            escritorioASanitario.add(pcf);
            escritorioASanitario.moveToFront(pcf);
            escritorioASanitario.setSelectedFrame(pcf);
        }
        
    }//GEN-LAST:event_jMPostergarCitaxFaltanteActionPerformed

    private void jMCargarVacunasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMCargarVacunasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMCargarVacunasMouseClicked

    private void jMListarLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListarLabsActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            ListaLaboratorio listaLab = new ListaLaboratorio();
            listaLab.setVisible(true);
            escritorioASanitario.add(listaLab);
            escritorioASanitario.moveToFront(listaLab);
            escritorioASanitario.setSelectedFrame(listaLab);
        }
    }//GEN-LAST:event_jMListarLabsActionPerformed

    private void jMNuevoLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNuevoLabActionPerformed
        if(escritorioASanitario.getSelectedFrame()==null){
            escritorioASanitario.repaint();
            CargarLaboratorio cb = new CargarLaboratorio();
            cb.setVisible(true);
            escritorioASanitario.add(cb);
            escritorioASanitario.moveToFront(cb);
            escritorioASanitario.setSelectedFrame(cb);
        }
    }//GEN-LAST:event_jMNuevoLabActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorioASanitario;
    private javax.swing.JMenu jCitas;
    private javax.swing.JMenu jLaboratorios;
    private javax.swing.JMenuItem jMCargarVacunas;
    private javax.swing.JMenuItem jMConfCitas;
    private javax.swing.JMenuItem jMDosisDiarias;
    private javax.swing.JMenuItem jMListarCitas;
    private javax.swing.JMenuItem jMListarLabs;
    private javax.swing.JMenuItem jMListarVacunas;
    private javax.swing.JMenuItem jMListarVacxCentro;
    private javax.swing.JMenuItem jMNuevoLab;
    private javax.swing.JMenuItem jMPostergarCitaxFaltante;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jVacunas;
    // End of variables declaration//GEN-END:variables
}
