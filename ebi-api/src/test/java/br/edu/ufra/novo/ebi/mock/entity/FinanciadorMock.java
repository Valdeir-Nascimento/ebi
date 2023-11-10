package br.edu.ufra.novo.ebi.mock.entity;

import br.edu.ufra.novo.ebi.builder.FinanciadorBuilder;
import br.edu.ufra.novo.ebi.entity.Financiador;

import java.util.List;

public class FinanciadorMock {

    public static List<Financiador> recuperarFinanciadoresPorTrabalho() {

        Financiador financiador01 = FinanciadorBuilder.builder()
                .id(1)
                .nome("FADESP")
                .build();

        Financiador financiador02 = FinanciadorBuilder.builder()
                .id(2)
                .nome("IFPA")
                .build();

        return List.of(financiador01, financiador02);
    }

}
