package datos;

import domain.Secciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class SeccionDaoImpl implements SeccionDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Secciones> findAllSecciones() {
        return em.createNamedQuery("Secciones.findAll").getResultList();
    }

    @Override
    public Secciones findSeccionById(Secciones secciones) {
        return em.find(Secciones.class, secciones.getIdSecciones());
    }

    @Override
    public void insertSeccion(Secciones secciones) {
        em.persist(secciones);
    }

    @Override
    public void updateSeccion(Secciones secciones) {
        em.merge(secciones);
    }

    @Override
    public void deleteSeccion(Secciones secciones) {
        em.remove(em.merge(secciones));
    }


    
}
