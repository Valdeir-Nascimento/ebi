package br.com.ebi.novo.api.builder;

import br.com.ebi.novo.api.entity.Autor;

public class AutorBuilder {
    private Integer id;
    private String nome;
    private String abreviado;
    private String instituicao;

    public static AutorBuilder builder() {
        return new AutorBuilder();
    }

    public AutorBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public AutorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public AutorBuilder abreviado(String abreviado) {
        this.abreviado = abreviado;
        return this;
    }

    public AutorBuilder instituicao(String instituicao) {
        this.instituicao = instituicao;
        return this;
    }

    public Autor build() {
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNome(nome);
        autor.setAbreviado(abreviado);
        autor.setInstituicao(instituicao);
        return autor;
    }
}
