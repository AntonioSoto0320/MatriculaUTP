package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Cursos;

@Stateless
public class CursoDaoImpl implements CursoDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Cursos> findAllCursos() {
        return em.createNamedQuery("Cursos.findAll").getResultList();
    }

    @Override
    public Cursos findCursoById(Cursos cursos) {
        return em.find(Cursos.class, cursos.getIdCursos());
    }

    @Override
    public void insertCurso(Cursos cursos) {
        em.persist(cursos);
    }

    @Override
    public void updateCurso(Cursos cursos) {
        em.merge(cursos);
    }

    @Override
    public void deleteCurso(Cursos cursos) {
        em.remove(em.merge(cursos));
    }

}
