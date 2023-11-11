package br.edu.ufra.novo.ebi.repository;

import br.edu.ufra.novo.ebi.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISalaRepository extends JpaRepository<Sala, Integer> {
}
