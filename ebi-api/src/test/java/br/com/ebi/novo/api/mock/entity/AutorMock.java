package br.com.ebi.novo.api.mock.entity;

import br.com.ebi.novo.api.builder.AutorBuilder;
import br.com.ebi.novo.api.entity.Autor;

import java.util.List;

public class AutorMock {

    public static List<Autor> filtrarPalestrantes() {
        Autor autor01 = AutorBuilder.builder()
                .id(1)
                .instituicao("UFPA")
                .nome("Francisco Oliveira da Silva")
                .abreviado("Franciso Oliveira")
                .build();

        Autor autor02 = AutorBuilder.builder()
                .id(1)
                .instituicao("UFRA")
                .nome("Maria Edna Carneiro da Cruz")
                .abreviado("Maria Edna")
                .build();

        return List.of(autor01, autor02);
    }

}
