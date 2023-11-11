package br.com.ebi.novo.api.mock.entity;

import br.com.ebi.novo.api.builder.SalaBuilder;
import br.com.ebi.novo.api.builder.TipoAtividadeBuilder;
import br.com.ebi.novo.api.builder.TrabalhoBuilder;
import br.com.ebi.novo.api.builder.AtividadeBuilder;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.entity.Sala;
import br.com.ebi.novo.api.entity.TipoAtividade;
import br.com.ebi.novo.api.entity.Trabalho;
import br.com.ebi.novo.api.util.DataUtil;

import java.util.List;

public class TrabalhoMock {

    public static List<Trabalho> recuperarTrabalhosPorAtividade() {
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

        Atividade atividade = AtividadeBuilder.builder()
                .id(1)
                .nome("Identificação molecular de peixes")
                .resumo("Resumo")
                .inicio(DataUtil.convertStringToInstant("28-01-2019 10:30"))
                .fim(DataUtil.convertStringToInstant("28-01-2019 16:00"))
                .sala(sala)
                .tipoAtividade(tipoAtividade)
                .build();

        Trabalho trabalho = TrabalhoBuilder.builder()
                .id(1)
                .titulo("Artigo sobre identificação molecular de peixes")
                .resumo("Resumo")
                .palavrasChave("Peixes, biologia")
                .atividade(atividade)
                .build();

        return List.of(trabalho);
    }

}
