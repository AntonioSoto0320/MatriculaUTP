package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Aulas;

@Local
public interface AulaService {
      public List<Aulas> listarAulas();
    
    public Aulas encontrarAulaPorId(Aulas aulas);
    
    public void registrarAula(Aulas aulas);
    
    public void modificarAula(Aulas aulas);
    
    public void eliminarAula(Aulas aulas);
    
}
