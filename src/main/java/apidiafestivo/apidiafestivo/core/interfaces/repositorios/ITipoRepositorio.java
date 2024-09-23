package apidiafestivo.apidiafestivo.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apidiafestivo.apidiafestivo.dominio.Tipo;

@Repository
public interface ITipoRepositorio extends JpaRepository<Tipo, Integer> {

}
