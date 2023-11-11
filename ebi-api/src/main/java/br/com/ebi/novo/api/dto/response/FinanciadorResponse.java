package br.com.ebi.novo.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FinanciadorResponse {

    private Integer id;
    private String nome;

}
