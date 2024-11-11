package apidiafestivo.apidiafestivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apidiafestivo.apidiafestivo.dominio.Usuario;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1")
    Usuario obtener(String Usuario);

    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1 AND u.clave=?2")
    Usuario validarUsuario(String usuario, String clave);

}
