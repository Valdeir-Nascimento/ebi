package br.com.ebi.novo.api.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class TipoAtividadeResponse  {

    private Integer id;
    private String nome;
    private Boolean listarPalestrantes;

}
