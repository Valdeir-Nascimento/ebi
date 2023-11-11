package br.com.ebi.novo.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
public class TrabalhoRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 1, max = 250)
    private String titulo;

    @NotBlank
    @Size(min = 1, max = 500)
    private String resumo;

    @NotBlank
    @Size(max = 150)
    private String palavrasChave;

    @Valid
    private AtividadeRequest atividade;

}
