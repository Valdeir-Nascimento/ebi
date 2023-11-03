package br.edu.ufra.novo.ebi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoAtividadeResponse  {

    private Integer id;
    private String nome;
    private Boolean listarPalestrantes;

}
