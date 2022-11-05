package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Cursos;

@Local
public interface CursoService {
      public List<Cursos> listarCursos();
    
    public Cursos encontrarCursoPorId(Cursos alumnos);
    
    public void registrarCurso(Cursos alumnos);
    
    public void modificarCurso(Cursos alumnos);
    
    public void eliminarCurso(Cursos alumnos);
    
}
