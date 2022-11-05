package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Modalidad;

@Local
public interface ModalidadService {
      public List<Modalidad> listarModalidades();
    
    public Modalidad encontrarModalidadPorId(Modalidad modalidad);
    
    public void registrarModalidad(Modalidad modalidad);
    
    public void modificarModalidad(Modalidad modalidad);
    
    public void eliminarModalidad(Modalidad modalidad);
    
}
