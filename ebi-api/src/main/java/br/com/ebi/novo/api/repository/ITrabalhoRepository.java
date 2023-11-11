package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITrabalhoRepository extends JpaRepository<Trabalho, Integer> {

    @Query("SELECT t FROM Trabalho t WHERE t.atividade.id = :idAtividade")
    List<Trabalho> filtrarTrbalhosPorAtividade(Integer idAtividade);

}
