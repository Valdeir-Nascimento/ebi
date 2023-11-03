package br.edu.ufra.novo.ebi.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
