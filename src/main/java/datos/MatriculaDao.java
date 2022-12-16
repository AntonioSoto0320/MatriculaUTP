package datos;

import domain.Matriculas;
import java.util.List;


public interface MatriculaDao {
    public List<Matriculas> findAllMatriculas();
    
    public Matriculas findMatriculaById(Matriculas matriculas);
    
    public List<Matriculas> findMatriculaAlumnoById(Matriculas matriculas);
    
    public void insertMatricula(Matriculas matriculas);
    
    public void updateMatricula(Matriculas matriculas);
    
    public void deleteMatricula(Matriculas matriculas);
    
    
}
