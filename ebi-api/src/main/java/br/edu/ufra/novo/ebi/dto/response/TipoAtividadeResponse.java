package br.edu.ufra.novo.ebi.dto.response;

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
