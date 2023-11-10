package br.edu.ufra.novo.ebi.mock.entity;

import br.edu.ufra.novo.ebi.builder.AtividadeBuilder;
import br.edu.ufra.novo.ebi.builder.SalaBuilder;
import br.edu.ufra.novo.ebi.builder.TipoAtividadeBuilder;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.util.DataUtil;

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
