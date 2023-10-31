package br.edu.ufra.novo.ebi.repository;

import br.edu.ufra.novo.ebi.entity.Versao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVersaoRepository extends JpaRepository<Versao, Integer> {

    @Query("SELECT MAX(v.id) from Versao v")
    Integer ultimaVersao();

}
