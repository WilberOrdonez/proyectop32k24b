
package modelo;

//Importan Librerias, principalmente la de Alumnos
import controlador.subAlumnos;
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
 * @author carlos david
 */
//Creacion de la clase Alumnos Dao y los parametros de la base de datos
public class subAlumnosDAO {
 
    private static final String SQL_SELECT = "SELECT nombre_subalumno, titulo_alumno, evubi_alumno, foto_alumno, DPI_alumno, formulario_alumno, certificado, comins_alumno FROM subalumnos";
    private static final String SQL_INSERT = "INSERT INTO subalumnos(nombre_subalumno, titulo_alumno, evubi_alumno, foto_alumno, DPI_alumno, formulario_alumno, certificado, comins_alumno) VALUES(?, ?, ?, ?, ?, ?, ?, ?,)";
    private static final String SQL_UPDATE = "UPDATE subalumnos SET nombre_subalumno=?, titulo_alumno=?, evubi_alumno=?, foto_alumno=?, DPI_alumno=?, formulario_alumno=?, certificado=?, comins_alumno=? WHERE nombre_subalumno = ?";
    private static final String SQL_DELETE = "DELETE FROM subalumnos WHERE nombre_subalumno=?";
    private static final String SQL_QUERY = "SELECT nombre_subalumno, titulo_alumno, evubi_alumno, foto_alumno, DPI_alumno, formulario_alumno, certificado, comins_alumno FROM subalumnos WHERE nombre_subalumno = ?";
    
    public List<subAlumnos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        subAlumnos subalumno = null;
        List<subAlumnos> subalumnos = new ArrayList<subAlumnos>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carrera = rs.getString("nombre_subalumno");
                String sede = rs.getString("titulo_alumno");
                String jornada = rs.getString("evubi_alumno");
                String seccion = rs.getString("foto_alumno");
                String aula = rs.getString("DPI_alumno");
                String curso = rs.getString("formulario_alumno");
                String carnet = rs.getString("certificado");
                String nota = rs.getString("comins_alumno");
                
                subalumno = new subAlumnos();
                subalumno.setNombre_subalumno(carrera);
                subalumno.setCodigo_sede(sede);
                subalumno.setCodigo_jornada(jornada);
                subalumno.setCodigo_seccion(seccion);
                subalumno.setCodigo_aula(aula);
                subalumno.setCodigo_curso(curso);
                subalumno.setCertificado(carnet);
                subalumno.setNota_asignacioncursoalumno(nota);
                subalumnos.add(subalumno);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return subalumnos;
    }
    
    public int insert(subAlumnos subalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, subalumno.getNombre_subalumno());
            stmt.setString(2, subalumno.getCodigo_sede());
            stmt.setString(3, subalumno.getCodigo_jornada());
            stmt.setString(4, subalumno.getCodigo_seccion());
            stmt.setString(5, subalumno.getCodigo_aula());
            stmt.setString(6, subalumno.getCodigo_curso());
            stmt.setString(7, subalumno.getCertificado());
            stmt.setString(8, subalumno.getNota_asignacioncursoalumno());
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
    
    public int update(subAlumnos subalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, subalumno.getNombre_subalumno());
            stmt.setString(2, subalumno.getCodigo_jornada());
            stmt.setString(3, subalumno.getCodigo_seccion());
            stmt.setString(4, subalumno.getCodigo_aula());
            stmt.setString(5, subalumno.getCodigo_curso());
            stmt.setString(6, subalumno.getCertificado());
            stmt.setString(7, subalumno.getCertificado());
            stmt.setString(8, subalumno.getNota_asignacioncursoalumno());
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
    
    public int delete(subAlumnos subalumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, subalumno.getNombre_subalumno());
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
    
    public subAlumnos query(subAlumnos subalumno) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, subalumno.getCertificado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String carrera = rs.getString("nombre_subalumno");
                String sede = rs.getString("titulo_alumno");
                String jornada = rs.getString("evubi_alumno");
                String seccion = rs.getString("foto_alumno");
                String aula = rs.getString("DPI_alumno");
                String curso = rs.getString("formulario_alumno");
                String carnet = rs.getString("certificado");
                String nota = rs.getString("comins_alumno");
                
                subalumno = new subAlumnos();
                subalumno.setNombre_subalumno(carrera);
                subalumno.setCodigo_sede(sede);
                subalumno.setCodigo_jornada(jornada);
                subalumno.setCodigo_seccion(seccion);
                subalumno.setCodigo_aula(aula);
                subalumno.setCodigo_curso(curso);
                subalumno.setCertificado(carnet);
                subalumno.setNota_asignacioncursoalumno(nota);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return subalumno;
    }
}
