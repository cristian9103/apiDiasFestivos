package apidiafestivo.apidiafestivo.aplicacion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public boolean esFestivoTipo1(List<Festivo> listaFestivos, int año, int mes, int dia) {
        List<Date> listaFechaFestivos = new ArrayList<Date>();

        for (Festivo festivo : listaFestivos) {
            listaFechaFestivos.add(new Date(año - 1900, festivo.getMes() - 1, festivo.getDia()));
        }

        for (Date festivo : listaFechaFestivos) {
            if (festivo.compareTo(new Date(año - 1900, mes - 1, dia)) == 0)
                return true;
        }

        return false;
    }

    public boolean esFestivoTipo2(List<Festivo> listaFestivos, int año, int mes, int dia) {
        List<Date> listaFechaFestivos = new ArrayList<Date>();

        for (Festivo festivo : listaFestivos) {
            listaFechaFestivos.add(siguienteLunes(new Date(año - 1900, festivo.getMes() - 1, festivo.getDia())));
        }

        for (Date festivo : listaFechaFestivos) {
            if (festivo.compareTo(new Date(año - 1900, mes - 1, dia)) == 0)
                return true;
        }

        return false;
    }

    public boolean esFestivoTipo3(List<Festivo> listaFestivos, int año, int mes, int dia) {
        List<Date> listaFechaFestivos = new ArrayList<Date>();
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = incrementarDias(domingoRamos, 7);

        for (Festivo festivo : listaFestivos) {
            listaFechaFestivos.add(incrementarDias(domingoPascua, festivo.getDiasPascua()));
        }

        for (Date festivo : listaFechaFestivos) {
            if (festivo.compareTo(new Date(año - 1900, mes - 1, dia)) == 0)
                return true;
        }
        
        return false;
    }

    public boolean esFestivoTipo4(List<Festivo> listaFestivos, int año, int mes, int dia) {
        List<Date> listaFechaFestivos = new ArrayList<Date>();
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = incrementarDias(domingoRamos, 7);

        for (Festivo festivo : listaFestivos) {
            listaFechaFestivos.add(siguienteLunes(incrementarDias(domingoPascua, festivo.getDiasPascua())));
        }

        for (Date festivo : listaFechaFestivos) {
            if (festivo.compareTo(new Date(año - 1900, mes - 1, dia)) == 0)
                return true;
        }
        
        return false;
    }

    @Override
    public String verificar(int año, int mes, int dia) {
        List<Festivo> listaFestivosTipo1 = repositorio.Buscar(1);
        List<Festivo> listaFestivosTipo2 = repositorio.Buscar(2);
        List<Festivo> listaFestivosTipo3 = repositorio.Buscar(3);
        List<Festivo> listaFestivosTipo4 = repositorio.Buscar(4);
        
        try {
            LocalDate fecha = LocalDate.of(año, mes, dia);
        } catch (DateTimeException e) {
            return "Fecha No válida";
        }

        if (esFestivoTipo1(listaFestivosTipo1, año, mes, dia) || esFestivoTipo2(listaFestivosTipo2, año, mes, dia) || esFestivoTipo3(listaFestivosTipo3, año, mes, dia) || esFestivoTipo4(listaFestivosTipo4, año, mes, dia))
            return "Es Festivo";
        else 
            return "No es Festivo";
            
    }

    /*@Override
    public String verificar(int año, int mes, int dia) {
        List<Festivo> listaFestivos = repositorio.findAll();
        List<Festivo> listaFestivosTipo1 = new ArrayList<Festivo>();
        List<Festivo> listaFestivosTipo2 = new ArrayList<Festivo>();
        List<Festivo> listaFestivosTipo3 = new ArrayList<Festivo>();
        List<Festivo> listaFestivosTipo4 = new ArrayList<Festivo>();
        
        try {
            LocalDate fecha = LocalDate.of(año, mes, dia);
        } catch (DateTimeException e) {
            return "Fecha No válida";
        }

        for (Festivo festivo : listaFestivos) {
            if (festivo.getTipo().getId() == 1){
                listaFestivosTipo1.add(festivo);
            } else if (festivo.getTipo().getId() == 2){
                listaFestivosTipo2.add(festivo);
            }else if (festivo.getTipo().getId() == 3) {
                listaFestivosTipo3.add(festivo);
            } else {
                listaFestivosTipo4.add(festivo);
            }
        }

        if (esFestivoTipo1(listaFestivosTipo1, año, mes, dia) || esFestivoTipo2(listaFestivosTipo2, año, mes, dia) || esFestivoTipo3(listaFestivosTipo3, año, mes, dia) || esFestivoTipo4(listaFestivosTipo4, año, mes, dia))
            return "Es Festivo";
        else 
            return "No es Festivo";
            
    }*/

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
