package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.TipoAtividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoAtividadeRepository extends JpaRepository<TipoAtividade, Integer> {
}
