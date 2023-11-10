package br.edu.ufra.novo.ebi.builder;

import br.edu.ufra.novo.ebi.entity.Financiador;

public class FinanciadorBuilder {
    private Integer id;
    private String nome;

    public static FinanciadorBuilder builder() {
        return new FinanciadorBuilder();
    }

    public FinanciadorBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public FinanciadorBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Financiador build() {
        Financiador financiador = new Financiador();
        financiador.setId(id);
        financiador.setNome(nome);
        return financiador;
    }
}
