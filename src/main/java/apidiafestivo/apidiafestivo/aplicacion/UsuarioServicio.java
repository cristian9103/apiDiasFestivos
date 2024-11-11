package apidiafestivo.apidiafestivo.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apidiafestivo.apidiafestivo.aplicacion.seguridad.SeguridadServicio;
import apidiafestivo.apidiafestivo.core.interfaces.repositorios.IUsuarioRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.IUsuarioServicio;
import apidiafestivo.apidiafestivo.dominio.Usuario;
import apidiafestivo.apidiafestivo.dominio.DTOs.UsuarioLoginDto;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    private IUsuarioRepositorio repositorio;
    @Autowired
    private SeguridadServicio servicioSeguridad;

    public UsuarioServicio(IUsuarioRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public UsuarioLoginDto login(String nombreUsuario, String clave) {
        Usuario usuarioObtenido = repositorio.validarUsuario(nombreUsuario, clave);
        UsuarioLoginDto userLoginDto = new UsuarioLoginDto(usuarioObtenido);
        if (usuarioObtenido != null){
            userLoginDto.setToken(servicioSeguridad.generarToken(nombreUsuario));
        }
        return userLoginDto;
    }

    @Override
    public List<Usuario> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Usuario obtener(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public Usuario agregar(Usuario Usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public Usuario modificar(Usuario Usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
