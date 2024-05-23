
package controlador;

/**
 *
 * @author kenph
 */
//Creacion de la nueva Clase Alumnos, creando las variables privadas tipo String
public class AsignacionAlumnos {
    private String codigo_carrera;
    private String codigo_sede;
    private String codigo_jornada;
    private String codigo_seccion;
    private String codigo_aula;
    private String codigo_curso;
    private String carnet_alumno;
    private String nota_asignacioncursoalumno;
    
    //Constructor vacio
    public AsignacionAlumnos() {
    }
    
    //To string para qué no nos salga los resultados en memoria
    @Override
    public String toString() {
        return "AsignacionAlumnos{" + "carnet_alumno=" + carnet_alumno + ", codigo_carrera=" + codigo_carrera + ", codigo_sede=" + codigo_sede + ", codigo_jornada=" + codigo_jornada + ", codigo_seccion=" + codigo_seccion + ", codigo_aula=" + codigo_aula + ", codigo_curso=" + codigo_curso + ", nota_asignacioncursoalumno=" + nota_asignacioncursoalumno + '}';
    }
    
    // Getter y Setter de cada uno de las variables
    public String getCarnet_alumno(){
        return carnet_alumno;
    }

    public void setCarnet_alumno(String carnet_alumno) {
        this.carnet_alumno = carnet_alumno;
    }

    public String getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(String codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getCodigo_jornada() {
        return codigo_jornada;
    }

    public void setCodigo_jornada(String codigo_jornada) {
        this.codigo_jornada = codigo_jornada;
    }

    public String getCodigo_seccion() {
        return codigo_seccion;
    }

    public void setCodigo_seccion(String codigo_seccion) {
        this.codigo_seccion = codigo_seccion;
    }

    public String getCodigo_aula() {
        return codigo_aula;
    }

    public void setCodigo_aula(String codigo_aula) {
        this.codigo_aula = codigo_aula;
    }
    
    public String getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }
    
    public String getNota_asignacioncursoalumno() {
        return codigo_curso;
    }

    public void setNota_asignacioncursoalumno(String nota_asignacioncursoalumno) {
        this.nota_asignacioncursoalumno = nota_asignacioncursoalumno;
    }
    
    //Constructores con variables individuales
    public AsignacionAlumnos(String carnet_alumno){
        this.carnet_alumno = carnet_alumno;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada, String codigo_seccion){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
        this.codigo_seccion = codigo_seccion;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada, String codigo_seccion, String codigo_aula){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
        this.codigo_seccion = codigo_seccion;
        this.codigo_aula = codigo_aula;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada, String codigo_seccion, String codigo_aula, String codigo_curso){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
        this.codigo_seccion = codigo_seccion;
        this.codigo_aula = codigo_aula;
        this.codigo_curso = codigo_curso;
    }
    
    public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada, String codigo_seccion, String codigo_aula, String codigo_curso, String codigo_carrera){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
        this.codigo_seccion = codigo_seccion;
        this.codigo_aula = codigo_aula;
        this.codigo_curso = codigo_curso;
        this.codigo_carrera = codigo_carrera;
    }
    
     public AsignacionAlumnos(String carnet_alumno, String codigo_sede, String codigo_jornada, String codigo_seccion, String codigo_aula, String codigo_curso, String codigo_carrera, String nota_asignacioncursoalumno){
        this.carnet_alumno = carnet_alumno;
        this.codigo_sede = codigo_sede;
        this.codigo_jornada = codigo_jornada;
        this.codigo_seccion = codigo_seccion;
        this.codigo_aula = codigo_aula;
        this.codigo_curso = codigo_curso;
        this.codigo_carrera = codigo_carrera;
        this.nota_asignacioncursoalumno = nota_asignacioncursoalumno;
    }    
}
