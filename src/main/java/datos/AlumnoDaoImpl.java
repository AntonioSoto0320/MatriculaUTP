package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Alumnos;

@Stateless
public class AlumnoDaoImpl implements AlumnoDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Alumnos> findAllAlumnos() {
        return em.createNamedQuery("Alumnos.findAll").getResultList();
    }

    @Override
    public Alumnos findAlumnoById(Alumnos alumnos) {
        return em.find(Alumnos.class, alumnos.getIdAlumnos());
    }

    @Override
    public void insertAlumno(Alumnos alumnos) {
        em.persist(alumnos);
    }

    @Override
    public void updateAlumno(Alumnos alumnos) {
        em.merge(alumnos);
    }

    @Override
    public void deleteAlumno(Alumnos alumnos) {
        em.remove(em.merge(alumnos));
    }

}
