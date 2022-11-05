package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Aulas;

@Stateless
public class AulaDaoImpl implements AulaDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Aulas> findAllAulas() {
        return em.createNamedQuery("Aulas.findAll").getResultList();
    }

    @Override
    public Aulas findAulaById(Aulas aulas) {
        return em.find(Aulas.class, aulas.getIdAulas());
    }

    @Override
    public void insertAula(Aulas aulas) {
        em.persist(aulas);
    }

    @Override
    public void updateAula(Aulas aulas) {
        em.merge(aulas);
    }

    @Override
    public void deleteAula(Aulas aulas) {
        em.remove(em.merge(aulas));
    }

}
