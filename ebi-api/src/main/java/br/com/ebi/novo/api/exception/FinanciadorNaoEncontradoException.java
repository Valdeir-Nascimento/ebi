package br.com.ebi.novo.api.exception;

import java.io.Serial;

public class FinanciadorNaoEncontradoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public FinanciadorNaoEncontradoException(Integer id) {
        super(String.format("Não foi encontrado registro de financiador com Id: %d", id));
    }

}
