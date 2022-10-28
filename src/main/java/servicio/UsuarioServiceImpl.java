package servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datos.UsuarioDao;
import domain.Docentes;
import domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    
    @Inject
    private UsuarioDao usuairoDao;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuairoDao.findAllUsuarios();
    }
    
    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return  usuairoDao.findUsuarioById(usuario);
    }
    
    @Override
    public void registrarUsuario(Usuario usuario) {
        usuairoDao.insertUsuario(usuario);
    }
    
    @Override
    public void modificarUsuario(Usuario usuario) {
        usuairoDao.updateUsuario(usuario);
    }
    
    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuairoDao.deleteUsuario(usuario);
    }
    
}
