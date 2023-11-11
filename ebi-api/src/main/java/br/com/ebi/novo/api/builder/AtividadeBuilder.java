package br.com.ebi.novo.api.builder;

import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.entity.Sala;
import br.com.ebi.novo.api.entity.TipoAtividade;

import java.time.Instant;

public class AtividadeBuilder {

    private Integer id;
    private String nome;
    private String resumo;
    private Instant inicio;
    private Instant fim;
    private TipoAtividade tipoAtividade;
    private Sala sala;

    public static AtividadeBuilder builder() {
        return new AtividadeBuilder();
    }

    public AtividadeBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public AtividadeBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AtividadeBuilder resumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public AtividadeBuilder inicio(Instant inicio) {
        this.inicio = inicio;
        return this;
    }

    public AtividadeBuilder fim(Instant fim) {
        this.fim = fim;
        return this;
    }

    public AtividadeBuilder tipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
        return this;
    }

    public AtividadeBuilder sala(Sala sala) {
        this.sala = sala;
        return this;
    }

    public Atividade build() {
        Atividade atividade = new Atividade();
        atividade.setId(id);
        atividade.setNome(nome);
        atividade.setResumo(resumo);
        atividade.setInicio(inicio);
        atividade.setFim(fim);
        atividade.setTipoAtividade(tipoAtividade);
        atividade.setSala(sala);
        return atividade;
    }
}
