
package modelo;

import controlador.Secciones;
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
 * @author visitante
 */
public class SeccionesDAO {

    private static final String SQL_SELECT = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones";
    private static final String SQL_INSERT = "INSERT INTO secciones(codigo_seccion, nombre_seccion, estatus_seccion) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE seccions SET nombre_seccion=?, estatus_seccion=? WHERE codigo_seccion = ?";
    private static final String SQL_DELETE = "DELETE FROM secciones WHERE codigo_seccion=?";
    private static final String SQL_QUERY = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE codigo_seccion = ?";

    public List<Secciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Secciones seccion = null;
        List<Secciones> secciones = new ArrayList<Secciones>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_seccion");
                String nombre = rs.getString("nombre_seccion");
                String estatus = rs.getString("estatus_seccion");
                
                seccion = new Secciones();
                seccion.setCodigo_seccion(codigo);
                seccion.setNombre_seccion(nombre);
                seccion.setEstatus_seccion(estatus);
                
                secciones.add(seccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return secciones;
    }

    public int insert(Secciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, seccion.getCodigo_seccion());
            stmt.setString(2, seccion.getNombre_seccion());
            stmt.setString(3, seccion.getEstatus_seccion());
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

    public int update(Secciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, seccion.getNombre_seccion());
            stmt.setString(2, seccion.getEstatus_seccion());
            stmt.setString(3, seccion.getCodigo_seccion());

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

    public int delete(Secciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, seccion.getCodigo_seccion());
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

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Secciones query(Secciones seccion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, seccion.getCodigo_seccion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_jornada");
                String nombre = rs.getString("nombre_jornada");
                String estatus = rs.getString("estatus_jornada");
                
                seccion = new Secciones();
                seccion.setCodigo_seccion(codigo);
                seccion.setNombre_seccion(nombre);
                seccion.setEstatus_seccion(estatus);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return seccion;
    }
        
}
