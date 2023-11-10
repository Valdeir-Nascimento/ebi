package br.edu.ufra.novo.ebi.service;

import br.edu.ufra.novo.ebi.dto.response.AutorResponse;

import java.util.List;

public interface IPalestranteService {

    List<AutorResponse> filtrarPalestrantes();

}
