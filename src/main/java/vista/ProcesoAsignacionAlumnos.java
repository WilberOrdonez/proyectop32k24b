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
        for (int i = 0; i < ciclos.size(); i++) {
            jcbCiclos.addItem(ciclos.get(i).getNombre_ciclo());
        
    }
        
        
}
    
    

        public void llenadoDeCombosAlumnos() {
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        List<Alumnos> alumnos = alumnosDAO.select();
        for (Alumnos alumno : alumnos) {
            String item = alumno.getCarnet_alumno() + "      " + alumno.getNombre_alumno();
            jcbAlumnos.addItem(item);
        }
    }
        
//    public void llenadoDeTablas() {
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Nombre del Curso");  // Agregamos solo una columna para el nombre del curso
//        CursosDAO cursoDAO = new CursosDAO();
//        List<Cursos> cursos = cursoDAO.select();
//        tblCursosAAsignar.setModel(modelo);
//        String[] dato = new String[1];  // Solo necesitamos una columna en el arreglo de datos
//        for (Cursos curso : cursos) {
//            dato[0] = curso.getCodigo_curso() + " "+ curso.getNombre_curso();
//            modelo.addRow(dato);
//        }
//    }
        
public void llenadoDeTablas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Curso a Asignar");
    CursosDAO cursoDAO = new CursosDAO();
    List<Cursos> cursos = cursoDAO.select();
    tblCursosAAsignar.setModel(modelo);
    String[] dato = new String[1];

    String cicloSeleccionado = (String) jcbCiclos.getSelectedItem();
    

    int primero = 0;
    int ultimo = 0;

    switch (cicloSeleccionado) {
        case "1 Ciclo":
            primero = 101;
            ultimo = 105;
            break;
        case "2 Ciclo":
            primero = 106;
            ultimo = 110;
            break;
        case "3 Ciclo":
            primero = 111;
            ultimo = 115;
            break;
        case "4 Ciclo":
            primero = 116;
            ultimo = 120;
            break;
        case "5 Ciclo":
            primero = 121;
            ultimo = 125;
            break;
        case "6 Ciclo":
            primero = 126;
            ultimo = 130;
            break;
        case "7 Ciclo":
            primero = 131;
            ultimo = 135;
            break;
        case "8 Ciclo":
            primero = 136;
            ultimo = 140;
            break;
        case "9 Ciclo":
            primero = 141;
            ultimo = 145;
            break;
        case "10 Ciclo":
            primero = 146;
            ultimo = 150;
            break;
    }
        for (Cursos curso : cursos) {
            int codigoCurso = Integer.parseInt(curso.getCodigo_curso());
            if (codigoCurso >= primero && codigoCurso <= ultimo) {
                dato[0] = curso.getNombre_curso();
                modelo.addRow(dato);
            }
        }

}

    public ProcesoAsignacionAlumnos() {
        initComponents();
        llenadoDeCombosAlumnos();
        llenadoDeCombosCiclos();
        llenadoDeTablas();


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
        agregarUno = new javax.swing.JButton();
        agregarTodos = new javax.swing.JButton();
        quitarUno = new javax.swing.JButton();
        quitarTodos = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignacion de Cursos");
        setVisible(true);

        jcbCiclos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciclo" }));
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

        jcbAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Alumno" }));
        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        tblCursosAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cursos Asignados"
            }
        ));
        jScrollPane1.setViewportView(tblCursosAsignados);

        tblCursosAAsignar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Cursos a Asignar"
            }
        ));
        jScrollPane2.setViewportView(tblCursosAAsignar);

        agregarUno.setText(">");
        agregarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarUnoActionPerformed(evt);
            }
        });

        agregarTodos.setText(">>");
        agregarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTodosActionPerformed(evt);
            }
        });

        quitarUno.setText("<");
        quitarUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarUnoActionPerformed(evt);
            }
        });

        quitarTodos.setText("<<");
        quitarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quitarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregarUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quitarUno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarUno)
                        .addGap(18, 18, 18)
                        .addComponent(agregarTodos)
                        .addGap(18, 18, 18)
                        .addComponent(quitarUno)
                        .addGap(18, 18, 18)
                        .addComponent(quitarTodos)
                        .addGap(86, 86, 86))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCiclosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCiclosItemStateChanged
        llenadoDeTablas();
        
    }//GEN-LAST:event_jcbCiclosItemStateChanged

    private void jcbCiclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCiclosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCiclosActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlumnosActionPerformed

    private void agregarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarUnoActionPerformed
        int selectedRow = tblCursosAAsignar.getSelectedRow();

            DefaultTableModel modelAsignar = (DefaultTableModel) tblCursosAAsignar.getModel();
            DefaultTableModel modelAsignados = (DefaultTableModel) tblCursosAsignados.getModel();
            
            String curso = (String) modelAsignar.getValueAt(selectedRow, 0);
            modelAsignar.removeRow(selectedRow);
            modelAsignados.addRow(new Object[]{curso});
    }//GEN-LAST:event_agregarUnoActionPerformed

    private void agregarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTodosActionPerformed
        DefaultTableModel modelAsignar = (DefaultTableModel) tblCursosAAsignar.getModel();
        DefaultTableModel modelAsignados = (DefaultTableModel) tblCursosAsignados.getModel();
        
        int rowCount = modelAsignar.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String curso = (String) modelAsignar.getValueAt(0, 0);  // Siempre el primer elemento
            modelAsignar.removeRow(0);
            modelAsignados.addRow(new Object[]{curso});
        }
    }//GEN-LAST:event_agregarTodosActionPerformed

    private void quitarUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarUnoActionPerformed
        int selectedRow = tblCursosAsignados.getSelectedRow();
 
            DefaultTableModel modelAsignados = (DefaultTableModel) tblCursosAsignados.getModel();
            DefaultTableModel modelAsignar = (DefaultTableModel) tblCursosAAsignar.getModel();
            
            String curso = (String) modelAsignados.getValueAt(selectedRow, 0);
            modelAsignados.removeRow(selectedRow);
            modelAsignar.addRow(new Object[]{curso});
        
    }//GEN-LAST:event_quitarUnoActionPerformed

    private void quitarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarTodosActionPerformed
        DefaultTableModel modelAsignados = (DefaultTableModel) tblCursosAsignados.getModel();
        DefaultTableModel modelAsignar = (DefaultTableModel) tblCursosAAsignar.getModel();
        
        int rowCount = modelAsignados.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String curso = (String) modelAsignados.getValueAt(0, 0);  // Siempre el primer elemento
            modelAsignados.removeRow(0);
            modelAsignar.addRow(new Object[]{curso});
        }
    }//GEN-LAST:event_quitarTodosActionPerformed

/**/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarTodos;
    private javax.swing.JButton agregarUno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbAlumnos;
    private javax.swing.JComboBox<String> jcbCiclos;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JButton quitarTodos;
    private javax.swing.JButton quitarUno;
    private javax.swing.JTable tblCursosAAsignar;
    private javax.swing.JTable tblCursosAsignados;
    // End of variables declaration//GEN-END:variables
}
