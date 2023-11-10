package br.edu.ufra.novo.ebi.builder;

import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Trabalho;

public class TrabalhoBuilder {

    private Integer id;
    private String titulo;
    private String resumo;
    private String palavrasChave;
    private Atividade atividade;

    public static TrabalhoBuilder builder() {
        return new TrabalhoBuilder();
    }

    public TrabalhoBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public TrabalhoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public TrabalhoBuilder resumo(String resumo) {
        this.resumo = resumo;
        return this;
    }

    public TrabalhoBuilder palavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
        return this;
    }

    public TrabalhoBuilder atividade(Atividade atividade) {
        this.atividade = atividade;
        return this;
    }

    public Trabalho build() {
        Trabalho trabalho = new Trabalho();
        trabalho.setId(id);
        trabalho.setTitulo(titulo);
        trabalho.setResumo(resumo);
        trabalho.setPalavrasChave(palavrasChave);
        trabalho.setAtividade(atividade);
        return trabalho;
    }
}
