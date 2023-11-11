package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Autor;
import br.com.ebi.novo.api.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT DISTINCT a FROM Autor a INNER JOIN a.trabalhoList t WHERE t.atividade.tipoAtividade.listarPalestrantes = TRUE ORDER BY a.nome")
    List<Autor> obterPalestrantes();

    @Query("SELECT a FROM Autor a INNER JOIN a.trabalhoList t WHERE t = :trabalho ORDER BY a.nome")
    List<Autor> obter(Trabalho trabalho);

}
