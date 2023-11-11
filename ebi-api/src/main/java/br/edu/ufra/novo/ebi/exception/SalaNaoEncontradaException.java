package br.edu.ufra.novo.ebi.exception;

import java.io.Serial;

public class SalaNaoEncontradaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public SalaNaoEncontradaException(Integer id) {
        super(String.format("Não foi encontrado registro de sala com Id: %d", id));
    }

}
