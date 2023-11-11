package br.com.ebi.novo.api.dto.response;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class SalaResponse  {

    private Integer id;
    private String nome;
    private String imagem;

}
