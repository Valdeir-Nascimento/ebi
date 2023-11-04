package br.edu.ufra.novo.ebi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrabalhoResponse {

    private Integer id;
    private String titulo;
    private String resumo;
    private String palavrasChave;

}
