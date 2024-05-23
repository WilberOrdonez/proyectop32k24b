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

    // Verificar que la lista de cursos no esté vacía
    System.out.println("Cursos obtenidos: " + cursos.size());

    tblCursosAAsignar.setModel(modelo);
    String[] dato = new String[1];

    String cicloSeleccionado = (String) jcbCiclos.getSelectedItem();
    
    // Verificar el ciclo seleccionado
    System.out.println("Ciclo seleccionado: " + cicloSeleccionado);

    int codigoInicio = 0;
    int codigoFin = 0;

    switch (cicloSeleccionado) {
        case "1 Ciclo":
            codigoInicio = 101;
            codigoFin = 105;
            break;
        case "2 Ciclo":
            codigoInicio = 106;
            codigoFin = 110;
            break;
        case "3 Ciclo":
            codigoInicio = 111;
            codigoFin = 115;
            break;
        case "4 Ciclo":
            codigoInicio = 116;
            codigoFin = 120;
            break;
        case "5 Ciclo":
            codigoInicio = 121;
            codigoFin = 125;
            break;
        case "6 Ciclo":
            codigoInicio = 126;
            codigoFin = 130;
            break;
        case "7 Ciclo":
            codigoInicio = 131;
            codigoFin = 135;
            break;
        case "8 Ciclo":
            codigoInicio = 136;
            codigoFin = 140;
            break;
        case "9 Ciclo":
            codigoInicio = 141;
            codigoFin = 145;
            break;
        case "10 Ciclo":
            codigoInicio = 146;
            codigoFin = 150;
            break;
        default:
            System.out.println("Ciclo no válido seleccionado.");
    }

    if (codigoInicio > 0 && codigoFin > 0) {
        for (Cursos curso : cursos) {
            int codigoCurso = Integer.parseInt(curso.getCodigo_curso());
            if (codigoCurso >= codigoInicio && codigoCurso <= codigoFin) {
                dato[0] = curso.getNombre_curso();
                modelo.addRow(dato);
                System.out.println("Curso agregado: " + curso.getNombre_curso());
            }
        }
    } else {
        System.out.println("No se han definido los códigos de inicio y fin correctamente.");
    }

    // Verificar el número de filas añadidas al modelo
    System.out.println("Filas añadidas al modelo: " + modelo.getRowCount());
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
                {null},
                {null},
                {null},
                {null}
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCiclos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
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
