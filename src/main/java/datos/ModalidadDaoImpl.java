package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Modalidad;

@Stateless
public class ModalidadDaoImpl implements ModalidadDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Modalidad> findAllModalidades() {
        return em.createNamedQuery("Modalidad.findAll").getResultList();
    }

    @Override
    public Modalidad findModalidadById(Modalidad modalidad) {
        return em.find(Modalidad.class, modalidad.getIdModalidad());
    }

    @Override
    public void insertModalidad(Modalidad modalidad) {
        em.persist(modalidad);
    }

    @Override
    public void updateModalidad(Modalidad modalidad) {
        em.merge(modalidad);
    }

    @Override
    public void deleteModalidad(Modalidad modalidad) {
        em.remove(em.merge(modalidad));
    }

}
