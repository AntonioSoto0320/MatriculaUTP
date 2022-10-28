package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Docentes;

@Stateless
public class DocenteDaoImpl implements DocenteDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Docentes> findAllDocentes() {
        return em.createNamedQuery("Docentes.findAll").getResultList();
    }

    @Override
    public Docentes findDocenteById(Docentes docentes) {
        return em.find(Docentes.class, docentes.getIdDocentes());
    }

    @Override
    public void insertDocente(Docentes docentes) {
        em.persist(docentes);
    }

    @Override
    public void updateDocente(Docentes docentes) {
        em.merge(docentes);
    }

    @Override
    public void deleteDocente(Docentes docentes) {
        em.remove(em.merge(docentes));
    }

}
