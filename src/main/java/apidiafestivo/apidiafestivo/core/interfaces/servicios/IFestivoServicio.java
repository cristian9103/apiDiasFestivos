package apidiafestivo.apidiafestivo.core.interfaces.servicios;

import java.util.Date;
import java.util.List;

import apidiafestivo.apidiafestivo.dominio.Festivo;

public interface IFestivoServicio {

    public Date getDomingoRamos(Integer año);
    
    public Date incrementarDias(Date fecha, Integer dias);

    public Date siguienteLunes(Date fecha);

    public String verificar(int año, int mes, int dia);

    public List<Festivo> listar();

    public Festivo obtener(Integer id);

    public List<Festivo> buscar(String nombre);

    public Festivo agregar(Festivo festivo);

    public Festivo modificar(Festivo festivo);

    public boolean eliminar(Integer festivo);

}
