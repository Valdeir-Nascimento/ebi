package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;

import java.util.List;

public interface ITrabalhoPorAtividadeService {

    List<TrabalhoResponse> filtrarTrbalhosPorAtividade(Integer idAtividade);

}
