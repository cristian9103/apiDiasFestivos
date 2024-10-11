package apidiafestivo.apidiafestivo.core.interfaces.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apidiafestivo.apidiafestivo.dominio.Festivo;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
    @Query("SELECT f FROM Festivo f WHERE f.tipo.id = ?1")
    public List<Festivo> Buscar(int idTipo);
}
