package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Docentes;

@Local
public interface DocenteService {
      public List<Docentes> listarDocentes();
    
    public Docentes encontrarDocentePorId(Docentes docentes);
    
    public void registrarDocente(Docentes docentes);
    
    public void modificarDocente(Docentes docentes);
    
    public void eliminarDocente(Docentes docentes);
    
}
