package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Financiador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFinanciadorRepository extends JpaRepository<Financiador, Integer> {

    @Query("SELECT f FROM Financiador f INNER JOIN f.trabalhoList t WHERE t.id = :idTrabalho ORDER BY t.titulo")
    List<Financiador> filtrarFinanciadoresPorTrabalho(Integer idTrabalho);

}
