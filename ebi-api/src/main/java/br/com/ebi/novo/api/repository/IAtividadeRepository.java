package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAtividadeRepository extends JpaRepository<Atividade, Integer> {

    @Query("SELECT a FROM Atividade a WHERE a.tipoAtividade.id = :idTipoAtividade")
    List<Atividade> filtrarAtividadesPorTipo(Integer idTipoAtividade);

}
