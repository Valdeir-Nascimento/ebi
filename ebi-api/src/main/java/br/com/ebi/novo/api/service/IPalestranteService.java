package br.com.ebi.novo.api.service;

import br.com.ebi.novo.api.dto.response.AutorResponse;

import java.util.List;

public interface IPalestranteService {

    List<AutorResponse> filtrarPalestrantes();

}
