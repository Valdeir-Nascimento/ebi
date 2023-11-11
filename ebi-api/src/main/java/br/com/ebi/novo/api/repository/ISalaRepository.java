package br.com.ebi.novo.api.repository;

import br.com.ebi.novo.api.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalaRepository extends JpaRepository<Sala, Integer> {
}
