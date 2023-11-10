package br.edu.ufra.novo.ebi.controller;

import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.service.IAtividadePorTipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tipo-atividade")
public class AtividadePorTipoController {

    private final IAtividadePorTipoService atividadePorTipoService;

    @GetMapping("/{idTipoAtividade}/atividades")
    public ResponseEntity<List<AtividadeResponse>> filtrarAtividadesPorTipo(@PathVariable Integer idTipoAtividade) {
        List<AtividadeResponse> atividades = atividadePorTipoService.filtrarAtividadesPorTipo(idTipoAtividade);
        return ResponseEntity.ok().body(atividades);
    }

}
