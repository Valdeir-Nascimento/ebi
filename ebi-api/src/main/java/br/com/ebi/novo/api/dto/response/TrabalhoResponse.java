package br.com.ebi.novo.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TrabalhoResponse {

    private Integer id;
    private String titulo;
    private String resumo;
    private String palavrasChave;
    private AtividadeResponse atividade;

}
