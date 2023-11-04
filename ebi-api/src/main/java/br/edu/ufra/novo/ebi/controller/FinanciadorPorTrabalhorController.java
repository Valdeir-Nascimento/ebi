package br.edu.ufra.novo.ebi.controller;

import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;
import br.edu.ufra.novo.ebi.service.IFinanciadorPorTrabalhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/financiador-trabalho")
public class FinanciadorPorTrabalhorController {

    private final IFinanciadorPorTrabalhoService financiadorPorTrabalhoService;

    @GetMapping("/{idTrabalho}")
    public ResponseEntity<List<FinanciadorResponse>> filtrarFinanciadoresPorTrabalho(@PathVariable Integer idTrabalho) {
        List<FinanciadorResponse> financiadores = financiadorPorTrabalhoService.filtrarFinanciadoresPorTrabalho(idTrabalho);
        return ResponseEntity.ok().body(financiadores);
    }

}
