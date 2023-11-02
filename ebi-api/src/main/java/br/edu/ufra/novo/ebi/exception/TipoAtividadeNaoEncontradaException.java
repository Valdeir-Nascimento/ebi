package br.edu.ufra.novo.ebi.exception;

import java.io.Serial;

public class TipoAtividadeNaoEncontradaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TipoAtividadeNaoEncontradaException(Integer idTipoAtividade) {
        super(String.format("Não foi encontrado registro de tipo atividade com Id: %d", idTipoAtividade));
    }

}
