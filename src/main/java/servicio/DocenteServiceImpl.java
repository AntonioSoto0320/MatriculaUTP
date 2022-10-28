package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.DocenteDao;
import domain.Docentes;

@Stateless
public class DocenteServiceImpl implements DocenteService {
    
    @Inject
    private DocenteDao docenteDao;

    @Override
    public List<Docentes> listarDocentes() {
        return docenteDao.findAllDocentes();
    }
    
    @Override
    public Docentes encontrarDocentePorId(Docentes docentes) {
        return  docenteDao.findDocenteById(docentes); 
    }
    
    @Override
    public void registrarDocente(Docentes docentes) {
        docenteDao.insertDocente(docentes);
    }
    
    @Override
    public void modificarDocente(Docentes docentes) {
        docenteDao.updateDocente(docentes); 
    }
    
    @Override
    public void eliminarDocente(Docentes docentes) {
        docenteDao.deleteDocente(docentes); 
    }
    
}
