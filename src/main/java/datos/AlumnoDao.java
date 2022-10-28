package datos;

import java.util.List;
import domain.Alumnos;
import domain.Usuario;

public interface AlumnoDao {
    public List<Alumnos> findAllAlumnos();
    
    public Alumnos findAlumnoById(Alumnos alumnos);
    
    public void insertAlumno(Alumnos alumnos);
    
    public void updateAlumno(Alumnos alumnos);
    
    public void deleteAlumno(Alumnos alumnos);
    
}
