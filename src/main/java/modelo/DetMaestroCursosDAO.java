/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Leticia
 */
import controlador.documentosCursos;
import controlador.tablaCursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DetMaestroCursosDAO {
    private static final String SQL_SELECT = "SELECT * FROM documentosCursos";
    private static final String SQL_INSERT = "INSERT INTO documentosCursos VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE documentosCursos SET entregado=? WHERE codigo_documento=?";
    private static final String SQL_DELETE = "DELETE FROM documentosCursos WHERE codigo_documento=?";
    private static final String SQL_QUERY = "SELECT * FROM documentosCursos WHERE codigo_documento = ?";

    public List<documentosCursos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<documentosCursos> Documentos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigodocumento = rs.getString("codigo_documento");
                String codigocurso = rs.getString("codigo_curso");
                String nombredocumento = rs.getString("nombre_documento");
                String entregado = rs.getString("entregado");

                documentosCursos documento = new documentosCursos(codigodocumento, codigocurso, nombredocumento, entregado);
                Documentos.add(documento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return Documentos;
    }
    
    public List<tablaCursos> fillTable() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<tablaCursos> Documentos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement("SELECT \n" +
"	m.nombre_maestro,\n" +
"    c.nombre_curso,\n" +
"    CASE \n" +
"        WHEN SUM(CASE WHEN dc.entregado = '1' THEN 1 ELSE 0 END) = COUNT(*) THEN 'Solvente'\n" +
"        ELSE 'No solvente'\n" +
"    END AS estado,\n" +
"    SUM(CASE WHEN dc.entregado = '1' THEN 1 ELSE 0 END) AS documentos_entregados\n" +
"FROM \n" +
"    documentoscursos dc\n" +
"INNER JOIN \n" +
"    cursos c ON c.codigo_curso = dc.codigo_curso\n" +
"INNER JOIN \n" +
"    detmaestrocursos dtm ON dtm.codigo_curso = c.codigo_curso\n" +
"INNER JOIN \n" +
"    maestros m ON m.codigo_maestro = dtm.codigo_maestro\n" +
"GROUP BY \n" +
"    c.nombre_curso, m.nombre_maestro;\n" +
"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreMaestro = rs.getString("nombre_maestro");
                String nombreCurso = rs.getString("nombre_curso");
                String estado = rs.getString("estado");
                String documentosEntregados = rs.getString("documentos_entregados");

                tablaCursos tabla = new tablaCursos(nombreMaestro, nombreCurso, estado, documentosEntregados);
                Documentos.add(tabla);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return Documentos;
    }

    public int insert(documentosCursos Documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Documento.getCodigoDocumento());
            stmt.setString(2, Documento.getCodigoCurso());
            stmt.setString(3, Documento.getNombreDocumento());
            stmt.setString(4, Documento.getEntregado());
            System.out.println("Ejecutando query:" + SQL_INSERT);
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

    public int update(documentosCursos Documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, Documento.getCodigoDocumento());
            stmt.setString(2, Documento.getCodigoCurso());
            stmt.setString(3, Documento.getNombreDocumento());
            stmt.setString(4, Documento.getEntregado());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(documentosCursos Documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, Documento.getCodigoDocumento());
            stmt.setString(2, Documento.getCodigoCurso());
            stmt.setString(3, Documento.getNombreDocumento());
            stmt.setString(4, Documento.getEntregado());
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

    public documentosCursos query(documentosCursos Documento) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, Documento.getCodigoDocumento());
            stmt.setString(2, Documento.getCodigoCurso());
            stmt.setString(3, Documento.getNombreDocumento());
            stmt.setString(4, Documento.getEntregado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigodocumento = rs.getString("codigo_documento");
                String codigocurso = rs.getString("codigo_curso");
                String nombredocumento = rs.getString("nombre_documento");
                String entregado = rs.getString("entregado");

                Documento = new documentosCursos(codigodocumento, codigocurso, nombredocumento, entregado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Documento;
    }
}