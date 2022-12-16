package datos;

import domain.Alumnos;
import domain.Docentes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import domain.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import login.SessionUtils;

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
    public String usuarioValidation(Usuario usuario) {
        List<Usuario> usuarios = em.createNamedQuery("Usuario.findAll").getResultList();
        System.out.println("Lista de Usuarios:" + usuarios);
        String respuesta = "";
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario.getUsuario()) && user.getContraseña().equals(usuario.getContraseña())) {
                for (Alumnos alumno : user.getAlumnosList()) {
                    System.out.println("entre a alumno : " + alumno);
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user.getUsuario());
                    session.setAttribute("nombre", alumno.getNombre().concat(" ").concat(alumno.getApellido()));
                    session.setAttribute("usuario", user);
                    session.setAttribute("Alum", alumno);
                    session.setAttribute("idAlum", alumno.getIdAlumnos());
                }

                for (Docentes docente : user.getDocentesList()) {
                    System.out.println("entre a docente : " + docente);
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user.getUsuario());
                    session.setAttribute("nombre", docente.getNombre().concat(" ").concat(docente.getApellido()));
                    session.setAttribute("idDocente", docente.getIdDocentes());
                }

                for (Alumnos alumno : user.getAlumnosList()) {
                    System.out.println("entre a alumno : " + alumno);
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user.getUsuario());
                    session.setAttribute("nombre", alumno.getNombre().concat(" ").concat(alumno.getApellido()));

                }

                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user.getUsuario());

                session.setAttribute("rol", user.getIdRol().getTipoRol());

                String rolUrl = (String) session.getAttribute("rol");
                switch (rolUrl) {
                    case "Gestor Academico":
                        respuesta = "/faces/roles/gestorAcademico/pag_inicio.xhtml?faces-redirect=true";
                        break;

                    case "Docente":
                        respuesta = "/faces/roles/docente/inicio_docente.xhtml?faces-redirect=true";
                        break;

                    case "Estudiante":
                        respuesta = "/faces/roles/estudiante/inicio_alumno.xhtml?faces-redirect=true";
                        break;

                    default:
                        break;
                }

            }
        }

        if (!respuesta.isEmpty()) {
            System.out.println("entro : " + respuesta);
            return respuesta;
        } else {

            return "index.xhtml";
        }

    }

}
