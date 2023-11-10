package br.edu.ufra.novo.ebi.mock.entity;

import br.edu.ufra.novo.ebi.builder.AtividadeBuilder;
import br.edu.ufra.novo.ebi.builder.SalaBuilder;
import br.edu.ufra.novo.ebi.builder.TipoAtividadeBuilder;
import br.edu.ufra.novo.ebi.builder.TrabalhoBuilder;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.util.DataUtil;

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
