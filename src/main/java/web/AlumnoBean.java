package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Alumnos;
import servicio.AlumnoService;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

@Named("alumnoBean")
@RequestScoped
public class AlumnoBean {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private AlumnoService alumnoService;

    private Alumnos alumnoSeleccionado;
    
    List<Alumnos> alumnos;
    
    public AlumnoBean(){
        log.debug("Iniciando el objeto AlumnoBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Inciamos las variables
        this.alumnos = alumnoService.listarUsuarios();
        log.debug("alumnos recuperados en ManagedBean:" + this.alumnos);
        this.alumnoSeleccionado = new Alumnos();
    }
    
    public void editListener(RowEditEvent event){
        Alumnos alumno = (Alumnos) event.getObject();
        alumnoService.modificarUsuario(alumno);
    }
     
      public Alumnos getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumnos alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }
    
    public void agregarAlumno(){
        this.alumnoService.registrarUsuario(alumnoSeleccionado);
        this.alumnos.add(alumnoSeleccionado);
        this.alumnoSeleccionado = null;
    }
    
    public void eliminarAlumno(){
        this.alumnoService.eliminarUsuario(alumnoSeleccionado);
        this.alumnos.remove(this.alumnoSeleccionado);
        this.alumnoSeleccionado = null;
    }
    
    public void reiniciarAlumnoSeleccionado(){
        this.alumnoSeleccionado = new Alumnos();
    }
}
