package web;

import domain.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
@SessionScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    Logger log = LogManager.getRootLogger();

    boolean bandera = false;

    @Inject
    private UsuarioService usuarioService;

    private Usuario usuarioSeleccionado;

    public boolean isLoggedIn() {
        return usuario != null;
    }

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

        if (this.usuarioService.usuarioValidation(usuario).equals("index.xhtml")) {
            bandera = true;
        }

        return this.usuarioService.usuarioValidation(usuario);

    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/index.xhtml?faces-redirect=true";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showError() {
        if (bandera = true) {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o Contraseña Incorrectos");
        }

    }

    

}
