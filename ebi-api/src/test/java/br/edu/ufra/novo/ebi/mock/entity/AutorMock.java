package br.edu.ufra.novo.ebi.mock.entity;

import br.edu.ufra.novo.ebi.builder.AutorBuilder;
import br.edu.ufra.novo.ebi.entity.Autor;

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
