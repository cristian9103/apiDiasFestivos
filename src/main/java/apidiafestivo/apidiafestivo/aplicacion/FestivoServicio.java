package apidiafestivo.apidiafestivo.aplicacion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apidiafestivo.apidiafestivo.core.interfaces.repositorios.IFestivoRepositorio;
import apidiafestivo.apidiafestivo.core.interfaces.servicios.IFestivoServicio;
import apidiafestivo.apidiafestivo.dominio.Festivo;

@Service
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
        int d = (19 * a + 24) % 30;

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
    public String verificar(int año, int mes, int dia) {
        try {
            LocalDate fecha = LocalDate.of(año, mes, dia);
        } catch (DateTimeException e) {
            return "Fecha No válida";
        }

        List<Festivo> listaFestivos = repositorio.findAll();
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = incrementarDias(domingoRamos, 7);

        for (Festivo festivo : listaFestivos){
            if ((festivo.getTipo().getId() == 1 && new Date(año - 1900, festivo.getMes() - 1, festivo.getDia()).compareTo(new Date(año - 1900, mes - 1, dia)) == 0) || 
            (festivo.getTipo().getId() == 2 && siguienteLunes(new Date(año - 1900, festivo.getMes() - 1, festivo.getDia())).compareTo(new Date(año - 1900, mes - 1, dia)) == 0) ||
            (festivo.getTipo().getId() == 3 && incrementarDias(domingoPascua, festivo.getDiasPascua()).compareTo(new Date(año - 1900, mes - 1, dia)) == 0) ||
            (festivo.getTipo().getId() == 4 && siguienteLunes(incrementarDias(domingoPascua, festivo.getDiasPascua())).compareTo(new Date(año - 1900, mes - 1, dia)) == 0)){
                return "Es Festivo";
            }
        }
        return "No es Festivo";
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
