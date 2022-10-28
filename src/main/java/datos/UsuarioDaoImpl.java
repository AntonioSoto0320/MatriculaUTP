package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Usuario;
import java.util.Iterator;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "MatriculaUTP")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

    @Override
    public Usuario usuarioValidation(Usuario usuario) {
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario =:usuario AND u.contrase\u00f1a =:contraseña ");
        q.setParameter(":usuario", usuario.getUsuario());
        q.setParameter(":contraseña", usuario.getContraseña());
//FALTA HACER LA CONSULTA VALIDACION DE USUARIO
//        Iterator iter = q.getR    //getResultIterator();
//        while (iter.hasNext()) {
//            Usuario u = (Usuario) iter.next();
//            System.out.println("Found a claus with id " + c.id);
//        }

        em.getTransaction().commit();

        //por ahora retorna null
        return null;
    }

}
