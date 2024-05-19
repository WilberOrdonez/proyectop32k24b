/*

 */

package vista;

import modelo.EmpleadoDAO;
import modelo.CursosDAO;
import modelo.SeccionDAO;
import controlador.Empleado;
import controlador.Cursos;
import controlador.Seccion;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author visitante
 */
public class Pruebaventana extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
       /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        }*/
    }

    public Pruebaventana() {
        initComponents();
     //   llenadoDeTablas();
        llenadoDeCombos();
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        combo2 = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Proceso Asignacion Cursos");
        setVisible(true);

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Ciclo 1", "Ciclo 2" }));
        combo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1ItemStateChanged(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
        public String[]datos(String datos){
        String[] informacion = new String[5];
        if(datos.equalsIgnoreCase("Ciclo 1")){
            informacion[0]= "DESARROLLO HUMANO Y PROFESIONAL";
            informacion[1]= "METODOLOGÍA DE LA INVESTIGACIÓN";
            informacion[2]= "CONTABILIDAD I";
            informacion[3]= "INTRODUCCIÓN A LOS SISTEMAS DE CÓMPUTO";
            informacion[4]= "LÓGICA DE SISTEMAS";

        }
        if(datos.equalsIgnoreCase("Ciclo 2")){
            informacion[0]= "PRECÁLCULO";
            informacion[1]= "ÁLGEBRA LINEAL";
            informacion[2]= "ALGORITMOS";
            informacion[3]= "CONTABILIDAD II";
            informacion[4]= "MATEMÁTICA DISCRETA";
        }

      return informacion;
    }
    private void combo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(this.combo1.getSelectedIndex()>0){
                this.combo2.setModel(new DefaultComboBoxModel(this.datos(this.combo1.getSelectedItem().toString())));
            }
        }
    }//GEN-LAST:event_combo1ItemStateChanged

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    // End of variables declaration//GEN-END:variables
}
