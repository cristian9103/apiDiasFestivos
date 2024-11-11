package apidiafestivo.apidiafestivo.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apidiafestivo.apidiafestivo.core.interfaces.servicios.IUsuarioServicio;
import apidiafestivo.apidiafestivo.dominio.DTOs.UsuarioLoginDto;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio servicio;

    @RequestMapping(value = "/login/{nombreUsuario}/{clave}", method = RequestMethod.GET)
    public UsuarioLoginDto login(@PathVariable String nombreUsuario, @PathVariable String clave){
        return servicio.login(nombreUsuario, clave);
    }

}
