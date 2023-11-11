package br.com.ebi.novo.api.service;

import br.com.ebi.novo.api.dto.response.TrabalhoResponse;

import java.util.List;

public interface ITrabalhoPorAtividadeService {

    List<TrabalhoResponse> filtrarTrbalhosPorAtividade(Integer idAtividade);

}
