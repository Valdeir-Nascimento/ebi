package br.com.ebi.novo.api.service;

import br.com.ebi.novo.api.dto.response.AtividadeResponse;

import java.util.List;

public interface IAtividadePorTipoService {

    List<AtividadeResponse> filtrarAtividadesPorTipo(Integer idTipoAtividade);

}
