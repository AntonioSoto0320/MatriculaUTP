package datos;

import java.util.List;
import domain.Secciones;

public interface SeccionDao {
    public List<Secciones> findAllSecciones();
    
    public Secciones findSeccionById(Secciones secciones);
    
    public void insertSeccion(Secciones secciones);
    
    public void updateSeccion(Secciones secciones);
    
    public void deleteSeccion(Secciones secciones);
    
}
