package br.com.ebi.novo.api.mock.entity;

import br.com.ebi.novo.api.builder.FinanciadorBuilder;
import br.com.ebi.novo.api.entity.Financiador;

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
