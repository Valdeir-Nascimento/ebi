package br.edu.ufra.novo.ebi.mock.dto.request;

import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;

public class TipoAtividadeRequestMock {

    private TipoAtividadeRequestMock() {
    }

    public static TipoAtividadeRequest getTipoAtividade() {
        return TipoAtividadeRequest.builder()
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();
    }

}
