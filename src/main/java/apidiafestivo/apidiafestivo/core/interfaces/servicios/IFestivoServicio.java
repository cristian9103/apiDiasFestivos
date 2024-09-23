package apidiafestivo.apidiafestivo.core.interfaces.servicios;

import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public interface IFestivoServicio {

    public Date getDomingoRamos(Integer año);
    
    public Date incrementarDias(Date fecha, Integer dias);

    public Date siguienteLunes(Date fecha);

}
