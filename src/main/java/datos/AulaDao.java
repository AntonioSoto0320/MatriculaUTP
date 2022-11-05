package datos;

import java.util.List;
import domain.Aulas;

public interface AulaDao {
    public List<Aulas> findAllAulas();
    
    public Aulas findAulaById(Aulas aulas);
    
    public void insertAula(Aulas aulas);
    
    public void updateAula(Aulas aulas);
    
    public void deleteAula(Aulas aulas);
    
}
