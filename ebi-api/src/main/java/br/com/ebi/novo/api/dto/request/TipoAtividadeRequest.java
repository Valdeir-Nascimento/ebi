package br.com.ebi.novo.api.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@Builder
public class TipoAtividadeRequest implements Serializable {

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @NotNull
    private Boolean listarPalestrantes;

}
