package br.edu.ufra.novo.ebi.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Builder
public class AtividadeRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @Size(min = 1, max = 500)
    @NotBlank
    private String resumo;

    @NotBlank
    private String inicio;

    @NotBlank
    private String fim;

    @Valid
    private TipoAtividadeRequest tipo;

    @Valid
    private SalaRequest sala;

}
