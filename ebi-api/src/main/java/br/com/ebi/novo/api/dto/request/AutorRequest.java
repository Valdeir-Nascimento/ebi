package br.com.ebi.novo.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class AutorRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 1, max = 150)
    private String nome;

    @NotBlank
    @Size(max = 50)
    private String abreviado;

    @NotBlank
    @Size(min = 1, max = 50)
    private String instituicao;

}
