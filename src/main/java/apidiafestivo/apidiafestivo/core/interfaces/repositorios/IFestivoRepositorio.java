package apidiafestivo.apidiafestivo.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apidiafestivo.apidiafestivo.dominio.Festivo;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
    
}
