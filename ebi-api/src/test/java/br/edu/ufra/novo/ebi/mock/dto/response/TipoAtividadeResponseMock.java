package br.edu.ufra.novo.ebi.mock.dto.response;

import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;

import java.util.List;

public class TipoAtividadeResponseMock {

    private TipoAtividadeResponseMock() {
    }

    public static List<TipoAtividadeResponse> listarTodos() {

        TipoAtividadeResponse tipo01 = TipoAtividadeResponse.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        TipoAtividadeResponse tipo02 = TipoAtividadeResponse.builder()
                .id(1)
                .nome("Cursos")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        return List.of(tipo01, tipo02);
    }

    public static TipoAtividadeResponse getTipoAtividade() {
        return TipoAtividadeResponse.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();
    }

}
