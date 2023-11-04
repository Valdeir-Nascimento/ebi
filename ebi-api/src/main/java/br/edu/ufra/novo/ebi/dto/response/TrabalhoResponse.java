package br.edu.ufra.novo.ebi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TrabalhoResponse {

    private Integer id;
    private String titulo;
    private String resumo;
    private String palavrasChave;

}
