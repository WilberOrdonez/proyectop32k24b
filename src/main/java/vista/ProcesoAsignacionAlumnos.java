/*

 */

package vista;
import modelo.AlumnosDAO;
import controlador.Alumnos;
import modelo.CiclosDAO;
import controlador.Ciclos;
import modelo.CursosDAO;
import modelo.SeccionDAO;
import controlador.Cursos;
import controlador.Seccion;
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.JList;
import javax.swing.DefaultListModel;
/**
 *
 * @author visitante
 */
public class ProcesoAsignacionAlumnos extends javax.swing.JInternalFrame {


   
    public void llenadoDeCombosCiclos() {
      CiclosDAO ciclosDAO = new CiclosDAO();
        List<Ciclos> ciclos = ciclosDAO.select();
        jcbCiclos.addItem("Seleccione una opción");
        for (int i = 0; i < ciclos.size(); i++) {
            jcbCiclos.addItem(ciclos.get(i).getNombre_ciclo());
        
    }
        
        
}
    
    
    
    /*
    public void llenadoDeCombosCiclos() {
    CiclosDAO ciclosDAO = new CiclosDAO();
        List<Ciclos> ciclos = ciclosDAO.select();
        jcbCiclos.addItem("Seleccione una opción");
        for (Ciclos ciclo : ciclos) {
            jcbCiclos.addItem(ciclo.getNombre_ciclo());
    }
}
    */
        public void llenadoDeCombosAlumnos() {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        List<Alumnos> alumnos = alumnosDAO.select();
        for (Alumnos alumno : alumnos) {
            String item = alumno.getCarnet_alumno() + "      " + alumno.getNombre_alumno();
            jcbAlumnos.addItem(item);
        }
    }
    public ProcesoAsignacionAlumnos() {
        initComponents();
        llenadoDeCombosAlumnos();
        llenadoDeCombosCiclos();


    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        jcbCiclos = new javax.swing.JComboBox<>();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursosAsignados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursosAAsignar = new javax.swing.JTable();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Cursos");
        setVisible(true);

        jcbCiclos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCiclosItemStateChanged(evt);
            }
        });
        jcbCiclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCiclosActionPerformed(evt);
            }
        });

        tblCursosAsignados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCursosAsignados);

        tblCursosAAsignar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCursosAAsignar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(469, 469, 469))
            .addGroup(layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(815, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCiclosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCiclosItemStateChanged

    }//GEN-LAST:event_jcbCiclosItemStateChanged

    private void jcbCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCiclosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCiclosActionPerformed

/**/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbAlumnos;
    private javax.swing.JComboBox<String> jcbCiclos;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tblCursosAAsignar;
    private javax.swing.JTable tblCursosAsignados;
    // End of variables declaration//GEN-END:variables
}
