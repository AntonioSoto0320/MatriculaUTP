package servicio;

import datos.MatriculaDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import domain.Matriculas;


@Stateless
public class MatriculaServiceImpl implements MatriculaService {
    
    @Inject
    private MatriculaDao matriculaDao;

    @Override
    public List<Matriculas> listarMatriculas() {
        return matriculaDao.findAllMatriculas();
    }
    
    @Override
    public Matriculas encontrarMatriculaPorId(Matriculas matriculas) {
        return matriculaDao.findMatriculaById(matriculas);
    }
    
    @Override
    public List<Matriculas> encontrarMatriculaAlumnoPorId(Matriculas matriculas) {
        return matriculaDao.findMatriculaAlumnoById(matriculas);
    }
    
    @Override
    public void registrarMatricula(Matriculas matriculas) {
        matriculaDao.insertMatricula(matriculas);
    }
    
    @Override
    public void modificarMatricula(Matriculas matriculas) {
        matriculaDao.updateMatricula(matriculas);
    }
    
    @Override
    public void eliminarMatricula(Matriculas matriculas) {
        matriculaDao.deleteMatricula(matriculas);
    }
    
}
