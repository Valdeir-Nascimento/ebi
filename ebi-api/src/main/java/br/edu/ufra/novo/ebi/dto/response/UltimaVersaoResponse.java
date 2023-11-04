package br.edu.ufra.novo.ebi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public class UltimaVersaoResponse {
    
    Integer ultimaVersao;

}
