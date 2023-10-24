
package Vistas;

import AccesoDatos.*;
import entidades.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;


public class ListadoVacunasPorCentro extends javax.swing.JInternalFrame {

    
    DefaultTableModel modelo=new DefaultTableModel();
    
    
    
    public boolean inCellEditable(int f,int c){
        return false;
    }
    /**
     * Creates new form ListadoVacunasPorCentro
     */
    public ListadoVacunasPorCentro() {
        initComponents();
        cargarCabecera();
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
        jComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();

        jLabel1.setText("Seleccione un centro de vacunación");

        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        borrarFilas();
        String centro=(String)jComboBox.getSelectedItem();
        CitaVacunacionData cvd=new CitaVacunacionData();
        //ArrayList <Vacuna> vacunas=new ArrayList();
        List<CitaVacunacion> citasTotales=new ArrayList();
        VacunaData vd=new VacunaData();
        for(int i=1;i<13;i++){
            List<CitaVacunacion> citasXMes=new ArrayList();
            citasXMes=cvd.citasCumplidasPorMes(i);
            citasTotales.addAll(citasXMes);
        }
        Comparator <CitaVacunacion> CompararFecha=new Comparator <CitaVacunacion>(){
            public int compare(CitaVacunacion cv1,CitaVacunacion cv2){
                if(cv1.getFechaHoraCita().compareTo(cv2.getFechaHoraCita())==-1)return -1;
                //if(cv1.getFechaHoraCita() < cv2.getFechaHoraCita()) return -1;
                if(cv1.getFechaHoraCita() == cv2.getFechaHoraCita()) return 0;
                return 1;
            }
        };
        
        for(CitaVacunacion c:citasTotales){
            Vacuna v=vd.buscarVacuna(c.getVacuna().getNroSerieDosis());
            modelo.addRow(new Object[]{v.getMarca(),c.getVacuna().getNroSerieDosis(),c.getCiudadano().getDni()});
        }
    }//GEN-LAST:event_jComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables

    public void cargarCabecera(){
        modelo.addColumn("Marca");
        modelo.addColumn("Vacuna(N° de dósis)");
        modelo.addColumn("DNI ciudadano");
        jTabla.setModel(modelo);
    }
    
    private void borrarFilas(){
        int f=jTabla.getRowCount()-1;      
        for(;f>=0;f--){
            modelo.removeRow(f);
        }
    }
    
    public void cargarComboBox(){
        
    }
}
