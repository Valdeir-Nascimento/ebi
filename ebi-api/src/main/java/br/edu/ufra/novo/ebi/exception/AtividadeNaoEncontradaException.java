package br.edu.ufra.novo.ebi.exception;

import java.io.Serial;

public class AtividadeNaoEncontradaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AtividadeNaoEncontradaException(Integer id) {
        super(String.format("Não foi encontrado registro de atividade com Id: %d", id));
    }

}
