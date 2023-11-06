package br.edu.ufra.novo.ebi.util;

import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.SalaResponse;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;

public class MockUtil {

    private MockUtil() {
    }

    public static Atividade getAtividade() {
        TipoAtividade tipo = getTipoAtividade();
        Sala sala = getSala();
        Atividade atividade = new Atividade();
        atividade.setId(1);
        atividade.setNome("Identificação molecular de peixes");
        atividade.setResumo("Resumo");
        atividade.setInicio(DataUtil.convertStringToInstant("28-01-2019 10:30"));
        atividade.setFim(DataUtil.convertStringToInstant("28-01-2019 16:00"));
        atividade.setSala(sala);
        atividade.setTipoAtividade(tipo);
        return atividade;
    }

    public static TipoAtividade getTipoAtividade() {
        TipoAtividade tipo = new TipoAtividade();
        tipo.setId(1);
        tipo.setNome("Simpósio");
        tipo.setListarPalestrantes(Boolean.TRUE);
        return tipo;
    }

    public static Sala getSala() {
        Sala sala = new Sala();
        sala.setId(1);
        sala.setNome("TAXONOMIA, FILOGENIA E EVOLUÇÃO");
        return sala;
    }


    public static TipoAtividadeResponse getTipoAtividadeResponse() {
        TipoAtividadeResponse response = new TipoAtividadeResponse();
        response.setId(1);
        response.setNome("Simpósio");
        response.setListarPalestrantes(Boolean.TRUE);
        return response;
    }

    public static SalaResponse getSalaResponse() {
        return new SalaResponse(1, "TAXONOMIA, FILOGENIA E EVOLUÇÃO", null);
    }

    public static AtividadeResponse getAtividadeResponse() {
        TipoAtividadeResponse tipo = getTipoAtividadeResponse();
        SalaResponse sala = getSalaResponse();
        AtividadeResponse response = new AtividadeResponse();
        response.setId(1);
        response.setNome("Identificação molecular de peixes");
        response.setResumo("Resumo");
        response.setInicio("28-01-2019 10:30");
        response.setFim("28-01-2019 16:00");
        response.setSala(sala);
        response.setTipoAtividade(tipo);
        return response;
    }

}
