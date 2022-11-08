package web;

import domain.Aulas;
import domain.Cursos;
import domain.Docentes;
import domain.Modalidad;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import org.apache.logging.log4j.*;


@Named("seccionBean")
@RequestScoped
public class SeccionBean {

    Logger log = LogManager.getRootLogger();

   
    
    private Aulas aula;
    private Docentes docente;
    private Cursos curso;
    private Modalidad modalidad;

    public SeccionBean() {
        log.debug("Iniciando el objeto SeccionBean");
    }

    @PostConstruct
    public void inicializar() {
        this.aula = new Aulas();
        this.docente = new Docentes();
        this.curso = new Cursos();
        this.modalidad = new Modalidad();

    }

    public Aulas getAula() {
        return aula;
    }

    public void setAula(Aulas aula) {
        this.aula = aula;
    }

    public Docentes getDocente() {
        return docente;
    }

    public void setDocente(Docentes docente) {
        this.docente = docente;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public void obtenerParametros() {

        log.debug("Aula: " + aula.getAula());
        log.debug("Docente: " + docente.getNombreCompleto());
        log.debug("Curso:" + curso.getNombre());
        log.debug("Modalidad: " + modalidad.getModalidad());

    }

}
