package datos;

import domain.Matriculas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class MatriculaDaoImpl implements MatriculaDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Matriculas> findAllMatriculas() {
        return em.createNamedQuery("Matriculas.findAll").getResultList();
    }

    @Override
    public Matriculas findMatriculaById(Matriculas matriculas) {
        return em.find(Matriculas.class, matriculas.getIdMatriculas());
    }

    @Override
    public List<Matriculas> findMatriculaAlumnoById(Matriculas matriculas) {
        return (List<Matriculas>) em.find(Matriculas.class, matriculas.getIdalumM());
    
    }
    
    

    @Override
    public void insertMatricula(Matriculas matriculas) {
        em.persist(matriculas);
    }

    @Override
    public void updateMatricula(Matriculas matriculas) {
        em.merge(matriculas);
    }

    @Override
    public void deleteMatricula(Matriculas matriculas) {
        em.remove(em.merge(matriculas));
    }

}
