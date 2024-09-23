package apidiafestivo.apidiafestivo.aplicacion;

import java.util.List;

import apidiafestivo.apidiafestivo.core.interfaces.repositorios.ITipoRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.ITipoServicio;
import apidiafestivo.apidiafestivo.dominio.Festivo;

public class TipoServicio implements ITipoServicio {

    private ITipoRepositorio repositorio;

    public TipoServicio(ITipoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public List<Festivo> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Festivo obtener(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtener'");
    }

    @Override
    public List<Festivo> buscar(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public Festivo agregar(Festivo tipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public Festivo modificar(Festivo tipo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
