package br.com.ebi.novo.api.mock.dto.request;

import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;

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
