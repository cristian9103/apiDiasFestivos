package apidiafestivo.apidiafestivo.presentacion;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apidiafestivo.apidiafestivo.core.interfaces.servicios.IFestivoServicio;

@RestController
@RequestMapping("/festivo")
public class FestivoControlador {

    private IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificar(@PathVariable Integer año, @PathVariable Integer mes, @PathVariable Integer dia) {
        return servicio.verificar(año, mes, dia);
    }

}
