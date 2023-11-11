package br.com.ebi.novo.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AutorResponse {

    private Integer id;
    private String nome;
    private String abreviado;
    private String instituicao;

}
