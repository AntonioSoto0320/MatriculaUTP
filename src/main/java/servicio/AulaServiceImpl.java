package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.AulaDao;
import domain.Aulas;

@Stateless
public class AulaServiceImpl implements AulaService {
    
    @Inject
    private AulaDao aulaDao;

    @Override
    public List<Aulas> listarAulas() {
        return aulaDao.findAllAulas();
    }
    
    @Override
    public Aulas encontrarAulaPorId(Aulas alumnos) {
        return aulaDao.findAulaById(alumnos);
    }
    
    @Override
    public void registrarAula(Aulas alumnos) {
        aulaDao.insertAula(alumnos);
    }
    
    @Override
    public void modificarAula(Aulas alumnos) {
        aulaDao.updateAula(alumnos);
    }
    
    @Override
    public void eliminarAula(Aulas alumnos) {
        aulaDao.deleteAula(alumnos);
    }
    
}
