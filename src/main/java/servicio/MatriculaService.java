package servicio;

import domain.Matriculas;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MatriculaService {
      public List<Matriculas> listarMatriculas();
    
    public Matriculas encontrarMatriculaPorId(Matriculas matriculas);
    
    public void registrarMatricula(Matriculas matriculas);
    
    public void modificarMatricula(Matriculas matriculas);
    
    public void eliminarMatricula(Matriculas matriculas);
    
    public Matriculas encontrarMatriculaAlumnoPorId(Matriculas matriculas);
    
}
