
package modelo;

//Importan Librerias, principalmente la de Alumnos
import controlador.AsignacionAlumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kenph
 */
//Creacion de la clase Alumnos Dao y los parametros de la base de datos
public class AsignacionAlumnosDAO {
 
    private static final String SQL_SELECT = "SELECT codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso, carnet_alumno, nota_asignacioncursoalumno FROM asignacioncursosalumnos";
    private static final String SQL_INSERT = "INSERT INTO asignacioncursosalumnos(codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso, carnet_alumno, nota_asignacioncursoalumno) VALUES(?, ?, ?, ?, ?, ?, ?, ?,)";
    private static final String SQL_UPDATE = "UPDATE asignacioncursosalumnos SET codigo_carrera=?, codigo_sede=?, codigo_jornada=?, codigo_seccion=?, codigo_aula=?, codigo_curso=?, carnet_alumno=?, nota_asignacioncursoalumno=? WHERE codigo_carrera = ?";
    private static final String SQL_DELETE = "DELETE FROM asignacioncursosalumnos WHERE codigo_carrera=?";
    private static final String SQL_QUERY = "SELECT codigo_carrera, codigo_sede, codigo_jornada, codigo_seccion, codigo_aula, codigo_curso, carnet_alumno, nota_asignacioncursoalumno FROM asignacioncursosalumnos WHERE codigo_carrera = ?";
    
    public List<AsignacionAlumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionAlumnos asignacionalumno = null;
        List<AsignacionAlumnos> asignacionalumnos = new ArrayList<AsignacionAlumnos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carrera = rs.getString("codigo_carrera");
                String sede = rs.getString("codigo_sede");
                String jornada = rs.getString("codigo_jornada");
                String seccion = rs.getString("codigo_seccion");
                String aula = rs.getString("codigo_aula");
                String curso = rs.getString("codigo_curso");
                String carnet = rs.getString("carnet_alumno");
                String nota = rs.getString("nota_asignacioncursoalumno");
                
                asignacionalumno = new AsignacionAlumnos();
                asignacionalumno.setCodigo_carrera(carrera);
                asignacionalumno.setCodigo_sede(sede);
                asignacionalumno.setCodigo_jornada(jornada);
                asignacionalumno.setCodigo_seccion(seccion);
                asignacionalumno.setCodigo_aula(aula);
                asignacionalumno.setCodigo_curso(curso);
                asignacionalumno.setCarnet_alumno(carnet);
                asignacionalumno.setNota_asignacioncursoalumno(nota);
                asignacionalumnos.add(asignacionalumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asignacionalumnos;
    }
    
    public int insert(AsignacionAlumnos asignacionalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacionalumno.getCodigo_carrera());
            stmt.setString(2, asignacionalumno.getCodigo_sede());
            stmt.setString(3, asignacionalumno.getCodigo_jornada());
            stmt.setString(4, asignacionalumno.getCodigo_seccion());
            stmt.setString(5, asignacionalumno.getCodigo_aula());
            stmt.setString(6, asignacionalumno.getCodigo_curso());
            stmt.setString(7, asignacionalumno.getCarnet_alumno());
            stmt.setString(8, asignacionalumno.getNota_asignacioncursoalumno());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int update(AsignacionAlumnos asignacionalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacionalumno.getCodigo_carrera());
            stmt.setString(2, asignacionalumno.getCodigo_jornada());
            stmt.setString(3, asignacionalumno.getCodigo_seccion());
            stmt.setString(4, asignacionalumno.getCodigo_aula());
            stmt.setString(5, asignacionalumno.getCodigo_curso());
            stmt.setString(6, asignacionalumno.getCarnet_alumno());
            stmt.setString(7, asignacionalumno.getCarnet_alumno());
            stmt.setString(8, asignacionalumno.getNota_asignacioncursoalumno());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int delete(AsignacionAlumnos asignacionalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacionalumno.getCodigo_carrera());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public AsignacionAlumnos query(AsignacionAlumnos asignacionalumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, asignacionalumno.getCarnet_alumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String carrera = rs.getString("codigo_carrera");
                String sede = rs.getString("codigo_sede");
                String jornada = rs.getString("codigo_jornada");
                String seccion = rs.getString("codigo_seccion");
                String aula = rs.getString("codigo_aula");
                String curso = rs.getString("codigo_curso");
                String carnet = rs.getString("carnet_alumno");
                String nota = rs.getString("nota_asignacioncursoalumno");
                
                asignacionalumno = new AsignacionAlumnos();
                asignacionalumno.setCodigo_carrera(carrera);
                asignacionalumno.setCodigo_sede(sede);
                asignacionalumno.setCodigo_jornada(jornada);
                asignacionalumno.setCodigo_seccion(seccion);
                asignacionalumno.setCodigo_aula(aula);
                asignacionalumno.setCodigo_curso(curso);
                asignacionalumno.setCarnet_alumno(carnet);
                asignacionalumno.setNota_asignacioncursoalumno(nota);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignacionalumno;
    }
}
