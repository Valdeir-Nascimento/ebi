package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;

import java.util.List;

public interface IAtividadePorTipoService {

    List<Atividade> filtrarAtividadesPorTipo(TipoAtividade tipo);

}
