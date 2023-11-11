package br.com.ebi.novo.api.exception;

import java.io.Serial;

public class AutorNaoEncontradoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AutorNaoEncontradoException(Integer id) {
        super(String.format("Não foi encontrado registro de autor com Id: %d", id));
    }

}
