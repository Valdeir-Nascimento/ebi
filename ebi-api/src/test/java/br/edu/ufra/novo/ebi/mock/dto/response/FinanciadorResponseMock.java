package br.edu.ufra.novo.ebi.mock.dto.response;

import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;

import java.util.List;

public class FinanciadorResponseMock {

    public static List<FinanciadorResponse> recuperarFinanciadoresPorTrabalho() {
        FinanciadorResponse financiador01 = FinanciadorResponse.builder()
                .id(1)
                .nome("FADESP")
                .build();

        FinanciadorResponse financiador02 = FinanciadorResponse.builder()
                .id(2)
                .nome("IFPA")
                .build();
        return List.of(financiador01, financiador02);
    }
}
