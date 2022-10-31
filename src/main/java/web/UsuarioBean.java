package web;

import domain.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import login.SessionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import servicio.UsuarioService;

/**
 *
 * @author anton
 */
@Named("usuarioBean")
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();
    
    
    Logger log = LogManager.getRootLogger();

    @Inject
    private UsuarioService usuarioService;

    private Usuario usuarioSeleccionado;

    List<Usuario> usuarios;

    public UsuarioBean() {
        log.debug("Iniciando el objeto UsuarioBean");
    }

    @PostConstruct
    public void inicializar() {
        //Inciamos las variables
        this.usuarios = usuarioService.listarUsuarios();
        log.debug("docentes recuperados en ManagedBean:" + this.usuarios);
        this.usuarioSeleccionado = new Usuario();
    }

    public void editListener(RowEditEvent event) {
        Usuario usuario = (Usuario) event.getObject();
        usuarioService.modificarUsuario(usuario);
    }
    

    public Usuario getUsuarioeSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario() {
        this.usuarioService.registrarUsuario(usuarioSeleccionado);
        this.usuarios.add(usuarioSeleccionado);
        this.usuarioSeleccionado = null;
    }

    public void eliminarUsuario() {
        this.usuarioService.eliminarUsuario(usuarioSeleccionado);
        this.usuarios.remove(this.usuarioSeleccionado);
        this.usuarioSeleccionado = null;
    }

    public void reiniciarUsuarioSeleccionado() {
        this.usuarioSeleccionado = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public String validarUsuario() {
        return this.usuarioService.usuarioValidation(usuario);
    }
    
     public String logout() {
            HttpSession session = SessionUtils.getSession();
            session.invalidate();
            return "index";
    }

}
