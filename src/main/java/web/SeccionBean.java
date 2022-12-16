package web;

import domain.Alumnos;
import domain.Aulas;
import domain.Cursos;
import domain.Docentes;
import domain.Matriculas;
import domain.Modalidad;
import domain.Secciones;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import login.SessionUtils;
import org.apache.logging.log4j.*;
import servicio.AlumnoService;
import servicio.AulaService;
import servicio.CursoService;
import servicio.DocenteService;
import servicio.MatriculaService;
import servicio.ModalidadService;
import servicio.SeccionService;

@Named("seccionBean")
@RequestScoped
public class SeccionBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private SeccionService seccionService;

    @Inject
    private CursoService cursoService;

    @Inject
    private ModalidadService modalidadService;

    @Inject
    private DocenteService docenteService;

    @Inject
    private AulaService aulaService;

    @Inject
    private AlumnoService alumnoService;

    @Inject
    private MatriculaService matriculaService;

    private Aulas aulaSeleccionada;
    private Docentes docenteSeleccionado;
    private Cursos cursoSeleccionado;
    private Modalidad modalidadSeleccionado;
    private Secciones seccion;
    private Alumnos alumno;
    private Matriculas matricula;
    private boolean disable;

    List<Modalidad> modalidades;
    List<Docentes> docentes;
    List<Cursos> cursos;
    List<Aulas> aulas;
    List<Matriculas> matriculas;
    List<Alumnos> alumnos;
    List<Secciones> secciones;
    List<Secciones> seccionesPrueba;
    List<Matriculas> matriculasprueba;
    
    Matriculas prueba;

    public SeccionBean() {
        log.debug("Iniciando el objeto SeccionBean");

    }

    @PostConstruct
    public void inicializar() {
        
       
        this.modalidades = modalidadService.listarModalidades();
        this.docentes = docenteService.listarDocentes();
        this.cursos = cursoService.listarCursos();
        this.aulas = aulaService.listarAulas();
        this.matriculas = matriculaService.listarMatriculas();
        this.secciones = seccionService.listarSecciones();
        this.alumnos = alumnoService.listarUsuarios();
       
        this.aulaSeleccionada = new Aulas();
        this.docenteSeleccionado = new Docentes();
        this.cursoSeleccionado = new Cursos();
        this.modalidadSeleccionado = new Modalidad();
        this.matricula = new Matriculas();

        this.alumno = new Alumnos();
        this.disable = true;
        
        this.matriculasprueba = listadoMatriculasAlumno(this.matriculas);
        

    }

    public List<Modalidad> completeModalidad(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Modalidad> listadoModalidades = modalidades;

        return listadoModalidades.stream().filter(t -> t.getModalidad().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Secciones> getSeccionesPrueba() {
        return seccionesPrueba;
    }

    public void setSeccionesPrueba(List<Secciones> seccionesPrueba) {
        this.seccionesPrueba = seccionesPrueba;
    }
    
    

    public List<Docentes> completeDocente(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Docentes> listadoDocentes = docentes;

        return listadoDocentes.stream().filter(t -> t.getNombreCompleto().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<Matriculas> getMatriculasprueba() {
        return matriculasprueba;
    }

    public void setMatriculasprueba(List<Matriculas> matriculasprueba) {
        this.matriculasprueba = matriculasprueba;
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

    public List<Secciones> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Secciones> secciones) {
        this.secciones = secciones;
    }

    public List<Matriculas> listadoMatriculasAlumno(List<Matriculas> matriculas) {
        HttpSession session = SessionUtils.getSession();

        int idAlum = (int) session.getAttribute("idAlum");
        List<Matriculas> matriculasAlumno = new ArrayList<>();

        List<Matriculas> matriculasA = matriculas;

        for (Matriculas matricula : matriculasA) {

            if (matricula.getIdalumM().getIdAlumnos() == idAlum) {

                

                matriculasAlumno.add(matricula);

            }

        }
        
        return matriculasAlumno;

    }
    
  
    
    

    
    
    
    public void obtenerParametros() {

        try {
            seccion = new Secciones(modalidadSeleccionado.getModalidad(), "activo", aulaSeleccionada, cursoSeleccionado, docenteSeleccionado);
            this.seccionService.registrarSeccion(seccion);
            //this.secciones.add(seccion);
            System.out.println("Aula: " + aulaSeleccionada.getAula());
            System.out.println("Docente: " + docenteSeleccionado.getNombreCompleto());
            System.out.println("Curso:" + cursoSeleccionado.getNombre());
            System.out.println("Modalidad: " + modalidadSeleccionado.getModalidad());
            //this.seccion = null;
            //showInfo();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            showError();
        }

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void validadSeccionCategorias() {

        if (aulaSeleccionada.getAula() == null || docenteSeleccionado.getNombreCompleto() == null
                || cursoSeleccionado.getNombre() == null || modalidadSeleccionado.getModalidad() == null) {

            System.out.println("errorrrrr");
        }

        showInfo();

    }

    public boolean validarObjetosVacios() {

        boolean bandera = false;

        try {
            if (modalidadSeleccionado.getModalidad() == null || cursoSeleccionado.getNombre() == null
                    || docenteSeleccionado.getNombreCompleto() == null || aulaSeleccionada.getAula() == null) {
                bandera = true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();

        }

        return bandera;
    }

    public void showInfo() {

        if (validarObjetosVacios()) {
            showError();
        } else {
            try {
                addMessage(FacesMessage.SEVERITY_INFO, "Seccion Creada", "Modalidad:"
                        + modalidadSeleccionado.getModalidad() + "\nCurso:" + cursoSeleccionado.getNombre()
                        + "\nDocente:" + docenteSeleccionado.getNombreCompleto() + "\nAula:" + aulaSeleccionada.getAula());
            } catch (NullPointerException e) {
                e.printStackTrace();
                //showError();
            }
        }

    }

    public void showSticky() {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Seccion Creada", "Modalidad:"
                + modalidadSeleccionado.getModalidad() + "\nCurso:" + cursoSeleccionado.getNombre()
                + "\nDocente:" + docenteSeleccionado.getNombreCompleto() + "\nAula:" + aulaSeleccionada.getAula()));
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Completar los campos faltantes");
    }

    public void confirm(Secciones secciones, Alumnos idAlumnos) {

        if (secciones != null && idAlumnos != null) {
            Matriculas matriculaInscripcion = new Matriculas(idAlumnos, secciones);

            matriculaService.registrarMatricula(matriculaInscripcion);

            addMessage("Confirmacion", "Curso Matriculado: " + secciones.getIdCurso().getNombre());
            desactivarBoton();

        }
    }

    public void desactivarBoton() {
        disable = false;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Matriculas getMatricula() {
        return matricula;
    }

    public void setMatricula(Matriculas matricula) {
        this.matricula = matricula;
    }

    public List<Matriculas> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matriculas> matriculas) {
        this.matriculas = matriculas;
    }

}
