package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Versao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVersaoRepository extends JpaRepository<Versao, Integer> {

    @Query("SELECT MAX(v.id) FROM Versao v")
    Integer ultimaVersao();

}
