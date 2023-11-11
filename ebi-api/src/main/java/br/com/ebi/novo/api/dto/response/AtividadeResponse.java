package br.com.ebi.novo.api.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeResponse {

    private Integer id;
    private String nome;
    private String resumo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String inicio;
    private String fim;
    private TipoAtividadeResponse tipoAtividade;
    private SalaResponse sala;

}
