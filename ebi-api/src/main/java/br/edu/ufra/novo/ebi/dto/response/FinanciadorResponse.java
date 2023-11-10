package br.edu.ufra.novo.ebi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FinanciadorResponse {

    private Integer id;
    private String nome;

}
