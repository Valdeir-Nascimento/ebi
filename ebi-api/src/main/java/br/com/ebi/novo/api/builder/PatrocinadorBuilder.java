package br.com.ebi.novo.api.builder;

import br.com.ebi.novo.api.entity.CategoriaPatrocinador;
import br.com.ebi.novo.api.entity.Patrocinador;

public class PatrocinadorBuilder {
    private Integer id;
    private String nome;
    private String site;
    private String logomarca;
    private CategoriaPatrocinador categoriaPatrocinador;

    public static PatrocinadorBuilder builder() {
        return new PatrocinadorBuilder();
    }

    public PatrocinadorBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public PatrocinadorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PatrocinadorBuilder site(String site) {
        this.site = site;
        return this;
    }

    public PatrocinadorBuilder logomarca(String logomarca) {
        this.logomarca = logomarca;
        return this;
    }

    public PatrocinadorBuilder categoriaPatrocinador(CategoriaPatrocinador categoriaPatrocinador) {
        this.categoriaPatrocinador = categoriaPatrocinador;
        return this;
    }

    public Patrocinador build() {
        Patrocinador patrocinador = new Patrocinador();
        patrocinador.setId(id);
        patrocinador.setNome(nome);
        patrocinador.setSite(site);
        patrocinador.setLogomarca(logomarca);
        patrocinador.setCategoriaPatrocinador(categoriaPatrocinador);
        return patrocinador;
    }
}
