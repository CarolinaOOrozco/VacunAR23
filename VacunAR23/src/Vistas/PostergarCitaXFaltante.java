/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author carol
 */
public class PostergarCitaXFaltante extends javax.swing.JInternalFrame {

    LocalDate lunes;
    LocalDate viernes;
    LocalDate hoy;
    public PostergarCitaXFaltante() {
        initComponents();
        hoy=LocalDate.now();
        seleccionarLunes();
        viernes=lunes.plusDays(4);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        jLInicioSemana.setText(lunes.format(dtf));
        jLFinDeLaSemana.setText(viernes.format(dtf));
        cargarComboBox();
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
        jLabel2 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLInicioSemana = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLFinDeLaSemana = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLVacunasDisponibles = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLCitasProgramadas = new javax.swing.JLabel();
        jBPostergar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Previsión de vacunas");

        jLabel2.setText("Semana");

        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Centro de vacunación");

        jLInicioSemana.setMinimumSize(new java.awt.Dimension(10, 10));

        jLabel5.setText("al");

        jLabel4.setText("Cantidad devacunas disponibles");

        jLabel6.setText("Citas programadas");

        jBPostergar.setText("Postergar");
        jBPostergar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(77, 77, 77)
                        .addComponent(jLCitasProgramadas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(jLVacunasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 204, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLInicioSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLFinDeLaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBPostergar)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLFinDeLaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLInicioSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLVacunasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLCitasProgramadas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jBPostergar)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        CitaVacunacionData cvd=new CitaVacunacionData();
        VacunaData vd=new VacunaData();
        String centro=(String)jComboBox.getSelectedItem();
        int vacunas=vd.vacunasDisponibles().size();
        jLVacunasDisponibles.setText(vacunas+"");
        int citasProgramadas=0;
        for(int i=0;i<=4;i++){
            citasProgramadas=citasProgramadas+cvd.vacunacionesDiarias(centro,lunes.plusDays(i)).size();
        }
        jLCitasProgramadas.setText(citasProgramadas+"");
        if(citasProgramadas>vacunas){
            JOptionPane.showMessageDialog(this, "Debe postergar las citas de la semana siguiente por faltante de dosis");
            jBPostergar.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBPostergar;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLCitasProgramadas;
    private javax.swing.JLabel jLFinDeLaSemana;
    private javax.swing.JLabel jLInicioSemana;
    private javax.swing.JLabel jLVacunasDisponibles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    public void seleccionarLunes(){
        switch(hoy.getDayOfWeek().getValue()){
            case(1):
                lunes=hoy.plusDays(7);break;
                case(2):
                    lunes=hoy.plusDays(6);break;
                    case(3):
                        lunes=hoy.plusDays(5);break;
                        case(4):
                            lunes=hoy.plusDays(4);break;
                            case(5):
                                lunes=hoy.plusDays(3);break;
                                case(6):
                                    lunes=hoy.plusDays(2);break;
                                    case(7):
                                        lunes=hoy.plusDays(1);break;
        }
    }
    
    public void cargarComboBox(){
        jComboBox.addItem("Hospital del Norte");
        jComboBox.addItem("Hospital del Oeste Dr. Atilio Luchini");
        jComboBox.addItem("Hospital del Sur");
        jComboBox.addItem("Hospital Ramón Carrillo");
        jComboBox.addItem("Policlínico");
    }
}
