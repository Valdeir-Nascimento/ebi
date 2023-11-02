package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;

public interface ITipoAtividadeService {

    TipoAtividadeResponse buscarPorId(Integer idTipoAtividade);

}
