/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Leticia
 */
public class documentosCursos{

    private String codigoDocumento;
    private String codigoCurso;
    private String nombreDocumento;
    private String entregado;
    
    public documentosCursos(String codigodocumento, String codigocurso, String nombredocumento, String entregado1) {
        this.codigoDocumento=codigodocumento;
        this.codigoCurso=codigocurso;
        this.nombreDocumento=nombredocumento;
        this.entregado=entregado1;
    }
    
    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }
    
    
    
    
    
}











