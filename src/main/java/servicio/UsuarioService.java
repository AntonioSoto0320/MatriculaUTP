package servicio;

import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioService {
      public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
    public String usuarioValidation(Usuario usuario);
    
}
