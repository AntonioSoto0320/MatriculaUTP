package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Secciones;

@Local
public interface SeccionService {
      public List<Secciones> listarSecciones();
    
    public Secciones encontrarSeccionPorId(Secciones secciones);
    
    public void registrarSeccion(Secciones secciones);
    
    public void modificarSeccion(Secciones secciones);
    
    public void eliminarSeccion(Secciones secciones);
    
}
