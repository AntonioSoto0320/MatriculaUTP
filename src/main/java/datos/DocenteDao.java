package datos;

import java.util.List;
import domain.Docentes;

public interface DocenteDao {
    public List<Docentes> findAllDocentes();
    
    public Docentes findDocenteById(Docentes docentes);
    
    public void insertDocente(Docentes docentes);
    
    public void updateDocente(Docentes docentes);
    
    public void deleteDocente(Docentes docentes);
    
}
