package apidiafestivo.apidiafestivo.aplicacion;

import java.util.Calendar;
import java.util.Date;

import apidiafestivo.apidiafestivo.core.interfaces.repositorios.IFestivoRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.IFestivoServicio;

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

    

}
