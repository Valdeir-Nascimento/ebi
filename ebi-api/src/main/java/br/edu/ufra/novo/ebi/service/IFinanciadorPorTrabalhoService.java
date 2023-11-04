package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;

import java.util.List;

public interface IFinanciadorPorTrabalhoService {

    List<FinanciadorResponse> filtrarFinanciadoresPorTrabalho(Integer idTrbalaho);

}
