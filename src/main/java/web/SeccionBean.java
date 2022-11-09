package web;

import domain.Aulas;
import domain.Cursos;
import domain.Docentes;
import domain.Modalidad;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.*;
import servicio.AulaService;
import servicio.CursoService;
import servicio.DocenteService;
import servicio.ModalidadService;

@Named("seccionBean")
@RequestScoped
public class SeccionBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private CursoService cursoService;

    @Inject
    private ModalidadService modalidadService;

    @Inject
    private DocenteService docenteService;

    @Inject
    private AulaService aulaService;

    private Aulas aulaSeleccionada;
    private Docentes docenteSeleccionado;
    private Cursos cursoSeleccionado;
    private Modalidad modalidadSeleccionado;

    List<Modalidad> modalidades;
    List<Docentes> docentes;
    List<Cursos> cursos;
    List<Aulas> aulas;

    public SeccionBean() {
        log.debug("Iniciando el objeto SeccionBean");

    }

    @PostConstruct
    public void inicializar() {
        this.modalidades = modalidadService.listarModalidades();
        this.docentes = docenteService.listarDocentes();
        this.cursos = cursoService.listarCursos();
        this.aulas = aulaService.listarAulas();

        this.aulaSeleccionada = new Aulas();
        this.docenteSeleccionado = new Docentes();
        this.cursoSeleccionado = new Cursos();
        this.modalidadSeleccionado = new Modalidad();

    }

    public List<Modalidad> completeModalidad(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Modalidad> listadoModalidades = modalidades;

        return listadoModalidades.stream().filter(t -> t.getModalidad().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Docentes> completeDocente(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Docentes> listadoDocentes = docentes;

        return listadoDocentes.stream().filter(t -> t.getNombreCompleto().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Aulas> completeAula(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Aulas> listadoAulas = aulas;

        return listadoAulas.stream().filter(t -> t.getAula().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Cursos> completeCurso(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Cursos> listadoCursos = cursos;

        return listadoCursos.stream().filter(t -> t.getNombre().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public Aulas getAulaSeleccionada() {
        return aulaSeleccionada;
    }

    public void setAulaSeleccionada(Aulas aulaSeleccionada) {
        this.aulaSeleccionada = aulaSeleccionada;
    }

    public Docentes getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(Docentes docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }

    public Cursos getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Cursos cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public Modalidad getModalidadSeleccionado() {
        return modalidadSeleccionado;
    }

    public void setModalidadSeleccionado(Modalidad modalidadSeleccionado) {
        this.modalidadSeleccionado = modalidadSeleccionado;
    }

    public List<Modalidad> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidad> modalidades) {
        this.modalidades = modalidades;
    }

    public List<Docentes> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docentes> docentes) {
        this.docentes = docentes;
    }

    public List<Cursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<Cursos> cursos) {
        this.cursos = cursos;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }

    public void obtenerParametros() {

        if (aulaSeleccionada.getAula().isEmpty()) {
            showError();
            System.out.println("entro al aula");
        }
        try {

            System.out.println("Aula: " + aulaSeleccionada.getAula());
            System.out.println("Docente: " + docenteSeleccionado.getNombreCompleto());
            System.out.println("Curso:" + cursoSeleccionado.getNombre());
            System.out.println("Modalidad: " + modalidadSeleccionado.getModalidad());

        } catch (Exception e) {
            e.printStackTrace(System.out);

        }

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void validadSeccionCategorias() {

        if (aulaSeleccionada.getAula() == null || docenteSeleccionado.getNombreCompleto() == null
                || cursoSeleccionado.getNombre() == null || modalidadSeleccionado.getModalidad() == null) {
            showError();
            System.out.println("errorrrrr antonio soto fut");
        }
        
        showInfo();

    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Seccion Creada", "Modalidad:"
                + modalidadSeleccionado.getModalidad() + "\nCurso:" + cursoSeleccionado.getNombre()
                + "\nDocente:" + docenteSeleccionado.getNombreCompleto() + "\nAula:" + aulaSeleccionada.getAula());
    }

    public void showSticky() {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Seccion Creada", "Modalidad:"
                + modalidadSeleccionado.getModalidad() + "\nCurso:" + cursoSeleccionado.getNombre()
                + "\nDocente:" + docenteSeleccionado.getNombreCompleto() + "\nAula:" + aulaSeleccionada.getAula()));
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Asignar todas las categorias de la seccion");
    }

}
