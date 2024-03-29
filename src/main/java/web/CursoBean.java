package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Cursos;
import java.util.stream.Collectors;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;
import servicio.CursoService;

@Named("cursoBean")
@RequestScoped
public class CursoBean {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private CursoService cursoService;

    private Cursos cursoSeleccionado;
    
    List<Cursos> cursos;
    
    public CursoBean(){
        log.debug("Iniciando el objeto CursoBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Inciamos las variables
        this.cursos = cursoService.listarCursos();
        log.debug("cursos recuperados en ManagedBean:" + this.cursos);
        this.cursoSeleccionado = new Cursos();
    }
    
     public List<Cursos> completeCurso(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Cursos> listadoCursos = cursos;
        
        return listadoCursos.stream().filter(t -> t.getNombre().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }
    
    public void editListener(RowEditEvent event){
        Cursos curso = (Cursos) event.getObject();
        cursoService.modificarCurso(curso);
    }
    
      public Cursos getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Cursos cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }
    
    public void agregarAlumno(){
        this.cursoService.registrarCurso(cursoSeleccionado);
        this.cursos.add(cursoSeleccionado);
        this.cursoSeleccionado = null;
    }
    
    public void eliminarAlumno(){
        this.cursoService.eliminarCurso(cursoSeleccionado);
        this.cursos.remove(this.cursoSeleccionado);
        this.cursoSeleccionado = null;
    }
    
    public void reiniciarAlumnoSeleccionado(){
        this.cursoSeleccionado = new Cursos();
    }
}
