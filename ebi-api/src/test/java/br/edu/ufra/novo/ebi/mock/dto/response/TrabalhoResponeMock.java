package br.edu.ufra.novo.ebi.mock.dto.response;

import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.SalaResponse;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;

import java.util.List;

public class TrabalhoResponeMock {

    public static List<TrabalhoResponse> recuperarTrabalhosPorAtividade() {
        SalaResponse sala = SalaResponse.builder()
                .id(1)
                .nome("TAXONOMIA, FILOGENIA E EVOLUÇÃO")
                .imagem(null)
                .build();

        TipoAtividadeResponse tipoAtividade = TipoAtividadeResponse.builder()
                .id(1)
                .nome("Simpósio")
                .listarPalestrantes(Boolean.TRUE)
                .build();

        AtividadeResponse atividade = AtividadeResponse.builder()
                .id(1)
                .nome("Identificação molecular de peixes")
                .resumo("Resumo")
                .inicio("28-01-2019 10:30")
                .fim("28-01-2019 16:00")
                .sala(sala)
                .tipoAtividade(tipoAtividade)
                .build();

        TrabalhoResponse trabalho = TrabalhoResponse.builder()
                .id(1)
                .titulo("Artigo sobre identificação molecular de peixes")
                .resumo("Resumo")
                .palavrasChave("Peixes, biologia")
                .atividade(atividade)
                .build();

        return List.of(trabalho);
    }

}
