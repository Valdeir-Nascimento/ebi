package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;

import java.util.List;

public interface IAtividadePorTipoService {

    List<AtividadeResponse> filtrarAtividadesPorTipo(Integer idTipoAtividade);

}
