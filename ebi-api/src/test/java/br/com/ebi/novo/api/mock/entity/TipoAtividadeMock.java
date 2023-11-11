package br.com.ebi.novo.api.mock.entity;

import br.com.ebi.novo.api.builder.TipoAtividadeBuilder;
import br.com.ebi.novo.api.entity.TipoAtividade;

import java.util.List;

public class TipoAtividadeMock {

    public static List<TipoAtividade> listarTodos() {

        TipoAtividade tipo01 = TipoAtividadeBuilder.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        TipoAtividade tipo02 = TipoAtividadeBuilder.builder()
                .id(1)
                .nome("Cursos")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        return List.of(tipo01, tipo02);
    }

    public static TipoAtividade getTipoAtividade() {
        return TipoAtividadeBuilder.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();
    }

}
