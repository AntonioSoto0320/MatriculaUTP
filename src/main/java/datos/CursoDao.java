package datos;

import java.util.List;
import domain.Cursos;

public interface CursoDao {
    public List<Cursos> findAllCursos();
    
    public Cursos findCursoById(Cursos cursos);
    
    public void insertCurso(Cursos cursos);
    
    public void updateCurso(Cursos cursos);
    
    public void deleteCurso(Cursos cursos);
    
}
