package servicio;

import java.util.List;
import javax.ejb.Local;
import domain.Alumnos;

@Local
public interface AlumnoService {
      public List<Alumnos> listarUsuarios();
    
    public Alumnos encontrarUsuarioPorId(Alumnos alumnos);
    
    public void registrarUsuario(Alumnos alumnos);
    
    public void modificarUsuario(Alumnos alumnos);
    
    public void eliminarUsuario(Alumnos alumnos);
    
}
