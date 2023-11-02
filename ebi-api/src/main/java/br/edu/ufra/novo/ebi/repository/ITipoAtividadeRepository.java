package br.edu.ufra.novo.ebi.repository;

import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoAtividadeRepository extends JpaRepository<TipoAtividade, Integer> {
}
