package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.SeccionDao;
import domain.Secciones;

@Stateless
public class SeccionServiceImpl implements SeccionService {
    
    @Inject
    private SeccionDao seccionDao;

    @Override
    public List<Secciones> listarSecciones() {
        return seccionDao.findAllSecciones();
    }
    
    @Override
    public Secciones encontrarSeccionPorId(Secciones secciones) {
        return seccionDao.findSeccionById(secciones);
    }
    
    @Override
    public void registrarSeccion(Secciones secciones) {
        seccionDao.insertSeccion(secciones);
    }
    
    @Override
    public void modificarSeccion(Secciones secciones) {
        seccionDao.updateSeccion(secciones);
    }
    
    @Override
    public void eliminarSeccion(Secciones secciones) {
        seccionDao.deleteSeccion(secciones);
    }
    
}
