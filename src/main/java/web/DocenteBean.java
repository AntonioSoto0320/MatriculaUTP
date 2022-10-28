package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Docentes;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;
import servicio.DocenteService;

@Named("docenteBean")
@RequestScoped
public class DocenteBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private DocenteService docenteService;

    private Docentes docenteSeleccionado;

    List<Docentes> docentes;

    public DocenteBean() {
        log.debug("Iniciando el objeto DocenteBean");
    }

    @PostConstruct
    public void inicializar() {
        //Inciamos las variables
        this.docentes = docenteService.listarDocentes();
        log.debug("docentes recuperados en ManagedBean:" + this.docentes);
        this.docenteSeleccionado = new Docentes();
    }

    public void editListener(RowEditEvent event) {
        Docentes docente = (Docentes) event.getObject();
        docenteService.modificarDocente(docente);
    }

    public Docentes getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(Docentes docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }

    public List<Docentes> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docentes> docentes) {
        this.docentes = docentes;
    }

    public void agregarDocente() {
        this.docenteService.registrarDocente(docenteSeleccionado);
        this.docentes.add(docenteSeleccionado);
        this.docenteSeleccionado = null;
    }

    public void eliminarDocente() {
        this.docenteService.eliminarDocente(docenteSeleccionado);
        this.docentes.remove(this.docenteSeleccionado);
        this.docenteSeleccionado = null;
    }

    public void reiniciarDocenteSeleccionado() {
        this.docenteSeleccionado= new Docentes();
    }
}
