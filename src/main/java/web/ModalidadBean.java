package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import domain.Modalidad;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;
import servicio.ModalidadService;

@Named("modalidadBean")
@RequestScoped
public class ModalidadBean {
    
    private Map<Integer,Modalidad> modalidadesAsMap;
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private ModalidadService modalidadService;

    private Modalidad modalidadSeleccionado;
    
    List<Modalidad> modalidades;
    
    public ModalidadBean(){
        log.debug("Iniciando el objeto ModalidadBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Inciamos las variables
        this.modalidades = modalidadService.listarModalidades();
        log.debug("modalidades recuperados en ManagedBean:" + this.modalidades);
        this.modalidadSeleccionado = new Modalidad();
    }
    
    public void editListener(RowEditEvent event){
        Modalidad modalidad = (Modalidad) event.getObject();
        modalidadService.modificarModalidad(modalidad);
    }
    
     public List<Modalidad> completeModalidad(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Modalidad> listadoModalidades = modalidades;
        
        return listadoModalidades.stream().filter(t -> t.getModalidad().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }
    

    public ModalidadService getModalidadService() {
        return modalidadService;
    }

    public void setModalidadService(ModalidadService modalidadService) {
        this.modalidadService = modalidadService;
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
    
    
    
    public void agregarModalidad(){
        this.modalidadService.registrarModalidad(modalidadSeleccionado);
        this.modalidades.add(modalidadSeleccionado);
        this.modalidadSeleccionado = null;
    }
    
    public void eliminarModalidad(){
        this.modalidadService.eliminarModalidad(modalidadSeleccionado);
        this.modalidades.remove(this.modalidadSeleccionado);
        this.modalidadSeleccionado = null;
    }
    
    public void reiniciarModalidadSeleccionado(){
        this.modalidadSeleccionado = new Modalidad();
    }
    
    public List<Modalidad> getModalidadesConverter() {
        return new ArrayList<>(modalidades);
    }

    public Map<Integer, Modalidad> getModalidadesAsMap() {
        if (modalidadesAsMap == null) {
            modalidadesAsMap = getModalidadesConverter().stream().collect(Collectors.toMap(Modalidad::getIdModalidad, modalidad -> modalidad));
        }
        return modalidadesAsMap;
    }
}
