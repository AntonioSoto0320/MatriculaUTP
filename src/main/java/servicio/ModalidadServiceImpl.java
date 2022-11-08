package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.ModalidadDao;
import domain.Modalidad;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class ModalidadServiceImpl implements ModalidadService {
    
    private Map<Integer, Modalidad> modalidadAsMap;
      private List<Modalidad> modalidades;

    @Inject
    private ModalidadDao modalidadDao;

    @Override
    public List<Modalidad> listarModalidades() {
        return modalidadDao.findAllModalidades();
    }

    @Override
    public Modalidad encontrarModalidadPorId(Modalidad modalidad) {
        return modalidadDao.findModalidadById(modalidad);
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
    
    public List<Modalidad> getModalidades() {
        return new ArrayList<>(modalidades);
    }

    @Override
    public Map<Integer, Modalidad> getCountriesAsMap() {
        if (modalidadAsMap == null) {
            modalidadAsMap = getModalidades().stream().collect(Collectors.toMap(Modalidad::getIdModalidad, modalidad -> modalidad));
        }
        return modalidadAsMap;
    }

}
