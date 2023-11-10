package br.edu.ufra.novo.ebi.mock.dto.response;

import br.edu.ufra.novo.ebi.dto.response.AutorResponse;

import java.util.List;

public class AutorResponseMock {

    public static List<AutorResponse> filtrarPalestrantes() {
        AutorResponse autor01 = AutorResponse.builder()
                .id(1)
                .instituicao("UFPA")
                .nome("Francisco Oliveira da Silva")
                .abreviado("Franciso Oliveira")
                .build();

        AutorResponse autor02 = AutorResponse.builder()
                .id(1)
                .instituicao("UFRA")
                .nome("Maria Edna Carneiro da Cruz")
                .abreviado("Maria Edna")
                .build();

        return List.of(autor01, autor02);
    }

}
