package br.com.ebi.novo.api.builder;

import br.com.ebi.novo.api.entity.TipoAtividade;

public class TipoAtividadeBuilder {
    private Integer id;
    private String nome;
    private Boolean listarPalestrantes;

    public static TipoAtividadeBuilder builder() {
        return new TipoAtividadeBuilder();
    }

    public TipoAtividadeBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public TipoAtividadeBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoAtividadeBuilder listarPalestrantes(Boolean listarPalestrantes) {
        this.listarPalestrantes = listarPalestrantes;
        return this;
    }

    public TipoAtividade build() {
        TipoAtividade tipoAtividade = new TipoAtividade();
        tipoAtividade.setId(id);
        tipoAtividade.setNome(nome);
        tipoAtividade.setListarPalestrantes(listarPalestrantes);
        return tipoAtividade;
    }

}
