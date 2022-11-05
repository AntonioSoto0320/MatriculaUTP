package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.CursoDao;
import domain.Cursos;

@Stateless
public class CursoServiceImpl implements CursoService {
    
    @Inject
    private CursoDao cursoDao;

    @Override
    public List<Cursos> listarCursos() {
        return cursoDao.findAllCursos();
    }
    
    @Override
    public Cursos encontrarCursoPorId(Cursos cursos) {
        return cursoDao.findCursoById(cursos);
    }
    
    @Override
    public void registrarCurso(Cursos cursos) {
        cursoDao.insertCurso(cursos);
    }
    
    @Override
    public void modificarCurso(Cursos cursos) {
        cursoDao.updateCurso(cursos);
    }
    
    @Override
    public void eliminarCurso(Cursos cursos) {
        cursoDao.deleteCurso(cursos);
    }
    
}
