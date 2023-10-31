package br.edu.ufra.novo.ebi.repository;

import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAtividadeRepository extends JpaRepository<Atividade, Integer> {

    @Query("SELECT a FROM Atividade a WHERE a.tipoAtividade.id = :tipo")
    List<Atividade> obter(TipoAtividade tipo);

}
