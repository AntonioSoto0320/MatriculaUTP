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
        String respuesta ="";
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario.getUsuario()) && user.getContraseña().equals(usuario.getContraseña())) {
                for (Alumnos alumno : user.getAlumnosList()) {
                    System.out.println("entre a alumno : " + alumno);
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user.getUsuario());
                    session.setAttribute("nombre", alumno.getNombre().concat(" ").concat(alumno.getApellido()));
                    session.setAttribute("usuario", user);
                }

                for (Docentes docente : user.getDocentesList()) {
                    System.out.println("entre a docente : " + docente);
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user.getUsuario());
                    session.setAttribute("nombre", docente.getNombre().concat(" ").concat(docente.getApellido()));

                }

                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", user.getUsuario());
                session.setAttribute("rol", user.getIdRol().getTipoRol());

//                respuesta = "/faces/roles/gestorAcademico/pag_inicio.xhtml?faces-redirect=true";
                String rolUrl = (String) session.getAttribute("rol");
                switch (rolUrl) {
                    case "Gestor Academico":
                        respuesta = "/faces/roles/gestorAcademico/pag_inicio.xhtml?faces-redirect=true";
                        break;

                    case "Docente":
                        respuesta = "hola.xhtml";
                        break;

                    default:
                        break;
                }

            }
        }

        if (!respuesta.isEmpty()) {
//            HttpSession session = SessionUtils.getSession();
//            session.setAttribute("username", usuario.getUsuario());
            System.out.println("entro : " + respuesta);
            return respuesta;
        } else {
            System.out.println("retorno :"+respuesta);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrecto Username y Password",
                            "Por favor ingrese un username y Password correctos"));
            return "index.xhtml";
        }

    }
}
