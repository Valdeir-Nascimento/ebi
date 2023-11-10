package br.edu.ufra.novo.ebi.dto.response;

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
