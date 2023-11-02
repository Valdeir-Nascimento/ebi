package br.edu.ufra.novo.ebi.dto.response;

import br.edu.ufra.novo.ebi.dto.request.SalaRequest;
import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AtividadeResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String resumo;
    private String inicio;
    private String fim;
    private TipoAtividadeRequest tipo;
    private SalaRequest sala;

}
