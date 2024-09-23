package apidiafestivo.apidiafestivo.aplicacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import apidiafestivo.apidiafestivo.core.interfaces.repositorios.IFestivoRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.IFestivoServicio;
import apidiafestivo.apidiafestivo.dominio.Festivo;

public class FestivoServicio implements IFestivoServicio {

    private IFestivoRepositorio repositorio;

    public FestivoServicio(IFestivoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public Date getDomingoRamos(Integer año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a +24) % 19;

        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        int dia = 15 + dias;
        int mes = 3;
        if (dia > 31){
            dia -= 31;
            mes = 4;
        }
        return new Date(año - 1900, mes -1, dia);
    }

    @Override
    public Date incrementarDias(Date fecha, Integer dias) {
        
        Calendar cld = Calendar.getInstance();
        cld.setTime(fecha);
        cld.add(Calendar.DATE, dias);
        return cld.getTime();
    }

    @Override
    public Date siguienteLunes(Date fecha) {

        Calendar cld = Calendar.getInstance();
        cld.setTime(fecha);
            
        int diaSemana = cld.get(Calendar.DAY_OF_WEEK);
        if (diaSemana != Calendar.MONDAY){
            if (diaSemana > Calendar.MONDAY){
                fecha = incrementarDias(fecha, 9 - diaSemana);
            } else {
                fecha = incrementarDias(fecha, 1);
            }
        }
        return fecha;       
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
