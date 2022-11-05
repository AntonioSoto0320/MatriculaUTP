package web;

import domain.Aulas;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.stream.Collectors;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;
import servicio.AulaService;

@Named("aulaBean")
@RequestScoped
public class AulaBean {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private AulaService aulaService;

    private Aulas aulaSeleccionada;
    
    List<Aulas> aulas;
    
    public AulaBean(){
        log.debug("Iniciando el objeto AulaBean");
    }
    
    @PostConstruct
    public void inicializar(){
        //Inciamos las variables
        this.aulas = aulaService.listarAulas();
        log.debug("aulas recuperados en ManagedBean:" + this.aulas);
        this.aulaSeleccionada = new Aulas();
    }
    
     public List<Aulas> completeAula(String query) {
        String queryLowerCase = query.toLowerCase();
        List<Aulas> listadoAulas = aulas;
        
        return listadoAulas.stream().filter(t -> t.getAula().toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }
    
    public void editListener(RowEditEvent event){
        Aulas aula = (Aulas) event.getObject();
        aulaService.modificarAula(aula);
    }

    public Aulas getAulaSeleccionada() {
        return aulaSeleccionada;
    }

    public void setAulaSeleccionada(Aulas aulaSeleccionada) {
        this.aulaSeleccionada = aulaSeleccionada;
    }

    public List<Aulas> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aulas> aulas) {
        this.aulas = aulas;
    }
    
    
    public void agregarAula(){
        this.aulaService.registrarAula(aulaSeleccionada);
        this.aulas.add(aulaSeleccionada);
        this.aulaSeleccionada = null;
    }
    
    public void eliminarAula(){
        this.aulaService.eliminarAula(aulaSeleccionada);
        this.aulas.remove(this.aulaSeleccionada);
        this.aulaSeleccionada = null;
    }
    
    public void reiniciarAulaSeleccionado(){
        this.aulaSeleccionada = new Aulas();
    }
}
