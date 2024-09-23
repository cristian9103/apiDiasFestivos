package apidiafestivo.apidiafestivo.core.interfaces.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apidiafestivo.apidiafestivo.dominio.Tipo;

@Service
public interface ITipoServicio {

    public List<Tipo> listar();

    public Tipo obtener(Integer id);

    public List<Tipo> buscar(String nombre);

    public Tipo agregar(Tipo tipo);

    public Tipo modificar(Tipo tipo);

    public boolean eliminar(Integer id);
}
