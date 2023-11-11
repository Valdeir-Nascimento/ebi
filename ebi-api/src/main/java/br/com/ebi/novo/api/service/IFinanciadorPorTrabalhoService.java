package br.com.ebi.novo.api.service;

import br.com.ebi.novo.api.dto.response.FinanciadorResponse;

import java.util.List;

public interface IFinanciadorPorTrabalhoService {

    List<FinanciadorResponse> filtrarFinanciadoresPorTrabalho(Integer idTrbalaho);

}
