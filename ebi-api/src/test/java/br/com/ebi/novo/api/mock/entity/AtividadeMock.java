package br.com.ebi.novo.api.mock.entity;

import br.com.ebi.novo.api.builder.AtividadeBuilder;
import br.com.ebi.novo.api.builder.SalaBuilder;
import br.com.ebi.novo.api.builder.TipoAtividadeBuilder;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.entity.Sala;
import br.com.ebi.novo.api.entity.TipoAtividade;
import br.com.ebi.novo.api.util.DataUtil;

import java.util.List;

public class AtividadeMock {

    public static List<Atividade> recuperarAtividadesPorTipo() {
        Sala sala = SalaBuilder.builder()
                .id(1)
                .nome("TAXONOMIA, FILOGENIA E EVOLUÇÃO")
                .imagem(null)
                .build();

        TipoAtividade tipoAtividade = TipoAtividadeBuilder.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        Atividade atividade = new AtividadeBuilder()
                .id(1)
                .nome("Identificação molecular de peixes")
                .resumo("Resumo")
                .inicio(DataUtil.convertStringToInstant("28-01-2019 10:30"))
                .fim(DataUtil.convertStringToInstant("28-01-2019 16:00"))
                .sala(sala)
                .tipoAtividade(tipoAtividade)
                .build();
        return List.of(atividade);
    }
}
