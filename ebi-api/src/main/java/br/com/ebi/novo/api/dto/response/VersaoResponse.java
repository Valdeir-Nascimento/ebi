package br.com.ebi.novo.api.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VersaoResponse {

    private Integer id;
    private String ultima;

}
