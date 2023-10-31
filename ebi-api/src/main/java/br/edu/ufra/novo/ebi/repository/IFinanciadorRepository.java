package br.edu.ufra.novo.ebi.repository;

import br.edu.ufra.novo.ebi.entity.Financiador;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFinanciadorRepository extends JpaRepository<Financiador, Integer> {

    @Query("SELECT f FROM Financiador f INNER JOIN f.trabalhoList t WHERE t = :trabalho ORDER BY t.titulo")
    List<Financiador> obter(Trabalho trabalho);

}
