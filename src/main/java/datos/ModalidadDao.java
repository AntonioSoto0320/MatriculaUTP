package datos;

import java.util.List;
import domain.Modalidad;

public interface ModalidadDao {
    public List<Modalidad> findAllModalidades();
    
    public Modalidad findModalidadById(Modalidad modalidad);
    
    public void insertModalidad(Modalidad modalidad);
    
    public void updateModalidad(Modalidad modalidad);
    
    public void deleteModalidad(Modalidad modalidad);
    
}
