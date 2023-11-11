package br.com.ebi.novo.api.builder;

import br.com.ebi.novo.api.entity.CategoriaPatrocinador;

public class CategoriaPatrocinadorBuilder {
    private Integer id;
    private String nome;
    private String icone;

    public static CategoriaPatrocinadorBuilder builder() {
        return new CategoriaPatrocinadorBuilder();
    }

    public CategoriaPatrocinadorBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public CategoriaPatrocinadorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public CategoriaPatrocinadorBuilder icone(String icone) {
        this.icone = icone;
        return this;
    }

    public CategoriaPatrocinador build() {
        CategoriaPatrocinador categoriaPatrocinador = new CategoriaPatrocinador();
        categoriaPatrocinador.setId(id);
        categoriaPatrocinador.setNome(nome);
        categoriaPatrocinador.setIcone(icone);
        return categoriaPatrocinador;
    }
}
