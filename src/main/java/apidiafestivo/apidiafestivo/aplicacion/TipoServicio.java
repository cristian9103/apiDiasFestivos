package apidiafestivo.apidiafestivo.aplicacion;

import java.util.List;

import org.springframework.stereotype.Service;

import apidiafestivo.apidiafestivo.core.interfaces.repositorios.ITipoRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.ITipoServicio;
import apidiafestivo.apidiafestivo.dominio.Tipo;

@Service
public class TipoServicio implements ITipoServicio {

    private ITipoRepositorio repositorio;

    public TipoServicio(ITipoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Tipo> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Tipo obtener(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    }

    @Override
    public List<Tipo> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public Tipo agregar(Tipo tipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public Tipo modificar(Tipo tipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    
}


