package br.edu.ufra.novo.ebi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AutorResponse {

    private Integer id;
    private String nome;
    private String abreviado;
    private String instituicao;

}
