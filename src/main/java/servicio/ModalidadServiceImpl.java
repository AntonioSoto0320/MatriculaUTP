package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.ModalidadDao;
import domain.Modalidad;

@Stateless
public class ModalidadServiceImpl implements ModalidadService {
    
    @Inject
    private ModalidadDao modalidadDao;
    
    @Override
    public List<Modalidad> listarModalidades() {
        return modalidadDao.findAllModalidades();
    }
    
    @Override
    public Modalidad encontrarModalidadPorId(Modalidad moadModalidad) {
        return modalidadDao.findModalidadById(moadModalidad);
    }
    
    @Override
    public void registrarModalidad(Modalidad modalidad) {
        modalidadDao.insertModalidad(modalidad);
    }
    
    @Override
    public void modificarModalidad(Modalidad modalidad) {
        modalidadDao.updateModalidad(modalidad);
    }
    
    @Override
    public void eliminarModalidad(Modalidad modalidad) {
        modalidadDao.deleteModalidad(modalidad);
    }
    
}
