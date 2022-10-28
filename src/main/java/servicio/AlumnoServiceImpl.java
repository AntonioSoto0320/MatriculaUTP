package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.AlumnoDao;
import domain.Alumnos;

@Stateless
public class AlumnoServiceImpl implements AlumnoService {
    
    @Inject
    private AlumnoDao alumnoDao;

    @Override
    public List<Alumnos> listarUsuarios() {
        return alumnoDao.findAllAlumnos();
    }
    
    @Override
    public Alumnos encontrarUsuarioPorId(Alumnos alumnos) {
        return alumnoDao.findAlumnoById(alumnos);
    }
    
    @Override
    public void registrarUsuario(Alumnos alumnos) {
        alumnoDao.insertAlumno(alumnos);
    }
    
    @Override
    public void modificarUsuario(Alumnos alumnos) {
        alumnoDao.updateAlumno(alumnos);
    }
    
    @Override
    public void eliminarUsuario(Alumnos alumnos) {
        alumnoDao.deleteAlumno(alumnos);
    }
    
}
