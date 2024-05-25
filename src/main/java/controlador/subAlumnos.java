
package controlador;

/**
 *
 * @author carlos david
 */
//Creacion de la nueva Clase Alumnos, creando las variables privadas tipo String
public class subAlumnos {
    private String nombre_subalumno;
    private String titulo_alumno;
    private String evubi_alumno;
    private String foto_alumno;
    private String DPI_alumno;
    private String formulario_alumno;
    private String certificado;
    private String comins_alumno;
    
    //Constructor vacio
    public subAlumnos() {
    }
    
    //To string para qué no nos salga los resultados en memoria
    @Override
    public String toString() {
        return "AsignacionAlumnos{" + "certificado=" + certificado + ", nombre_subalumno=" + nombre_subalumno + ", titulo_alumno=" + titulo_alumno + ", evubi_alumno=" + evubi_alumno + ", foto_alumno=" + foto_alumno + ", DPI_alumno=" + DPI_alumno + ", formulario_alumno=" + formulario_alumno + ", comins_alumno=" + comins_alumno + '}';
    }
    
    // Getter y Setter de cada uno de las variables
    public String getCertificado(){
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getNombre_subalumno() {
        return nombre_subalumno;
    }

    public void setNombre_subalumno(String nombre_subalumno) {
        this.nombre_subalumno = nombre_subalumno;
    }

    public String getCodigo_sede() {
        return titulo_alumno;
    }

    public void setCodigo_sede(String titulo_alumno) {
        this.titulo_alumno = titulo_alumno;
    }

    public String getCodigo_jornada() {
        return evubi_alumno;
    }

    public void setCodigo_jornada(String evubi_alumno) {
        this.evubi_alumno = evubi_alumno;
    }

    public String getCodigo_seccion() {
        return foto_alumno;
    }

    public void setCodigo_seccion(String foto_alumno) {
        this.foto_alumno = foto_alumno;
    }

    public String getCodigo_aula() {
        return DPI_alumno;
    }

    public void setCodigo_aula(String DPI_alumno) {
        this.DPI_alumno = DPI_alumno;
    }
    
    public String getCodigo_curso() {
        return formulario_alumno;
    }

    public void setCodigo_curso(String formulario_alumno) {
        this.formulario_alumno = formulario_alumno;
    }
    
    public String getNota_asignacioncursoalumno() {
        return formulario_alumno;
    }

    public void setNota_asignacioncursoalumno(String comins_alumno) {
        this.comins_alumno = comins_alumno;
    }
    
    //Constructores con variables individuales
    public subAlumnos(String certificado){
        this.certificado = certificado;
    }
    
    public subAlumnos(String certificado, String titulo_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
    }
    
    public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
    }
    
    public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno, String foto_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
        this.foto_alumno = foto_alumno;
    }
    
    public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno, String foto_alumno, String DPI_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
        this.foto_alumno = foto_alumno;
        this.DPI_alumno = DPI_alumno;
    }
    
    public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno, String foto_alumno, String DPI_alumno, String formulario_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
        this.foto_alumno = foto_alumno;
        this.DPI_alumno = DPI_alumno;
        this.formulario_alumno = formulario_alumno;
    }
    
    public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno, String foto_alumno, String DPI_alumno, String formulario_alumno, String nombre_subalumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
        this.foto_alumno = foto_alumno;
        this.DPI_alumno = DPI_alumno;
        this.formulario_alumno = formulario_alumno;
        this.nombre_subalumno = nombre_subalumno;
    }
    
     public subAlumnos(String certificado, String titulo_alumno, String evubi_alumno, String foto_alumno, String DPI_alumno, String formulario_alumno, String nombre_subalumno, String comins_alumno){
        this.certificado = certificado;
        this.titulo_alumno = titulo_alumno;
        this.evubi_alumno = evubi_alumno;
        this.foto_alumno = foto_alumno;
        this.DPI_alumno = DPI_alumno;
        this.formulario_alumno = formulario_alumno;
        this.nombre_subalumno = nombre_subalumno;
        this.comins_alumno = comins_alumno;
    }    
}
