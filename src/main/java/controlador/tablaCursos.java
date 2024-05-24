/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Leticia
 */
public class tablaCursos {
    private String nombreMaestro;
    private String nombreCurso;
    private String estado;
    private String NoDocumentos;
    
    public tablaCursos(String nombreMaestro, String nombreCurso, String estado, String NoDocumentos) {
        this.nombreMaestro = nombreMaestro;
        this.nombreCurso = nombreCurso;
        this.estado = estado;
        this.NoDocumentos = NoDocumentos;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNoDocumentos() {
        return NoDocumentos;
    }

    public void setNoDocumentos(String NoDocumentos) {
        this.NoDocumentos = NoDocumentos;
    }
    
}
