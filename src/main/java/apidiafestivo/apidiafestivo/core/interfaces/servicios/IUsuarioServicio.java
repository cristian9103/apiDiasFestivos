package apidiafestivo.apidiafestivo.core.interfaces.servicios;

import java.util.List;

import apidiafestivo.apidiafestivo.dominio.Usuario;
import apidiafestivo.apidiafestivo.dominio.DTOs.UsuarioLoginDto;

public interface IUsuarioServicio {

    public UsuarioLoginDto login(String nombreUsuario, String clave);
    
    public List<Usuario> listar();

    public Usuario obtener(Integer id);

    public List<Usuario> buscar(String nombre);

    public Usuario agregar(Usuario Usuario);

    public Usuario modificar(Usuario Usuario);

    public boolean eliminar(Integer id);
}
