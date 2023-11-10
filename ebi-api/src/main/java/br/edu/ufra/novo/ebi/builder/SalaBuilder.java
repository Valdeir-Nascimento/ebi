package br.edu.ufra.novo.ebi.builder;

import br.edu.ufra.novo.ebi.entity.Sala;

public class SalaBuilder {
    private Integer id;
    private String nome;
    private String imagem;

    public static SalaBuilder builder() {
        return new SalaBuilder();
    }

    public SalaBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public SalaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public SalaBuilder imagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public Sala build() {
        Sala sala = new Sala();
        sala.setId(id);
        sala.setNome(nome);
        sala.setImagem(imagem);
        return sala;
    }

}
