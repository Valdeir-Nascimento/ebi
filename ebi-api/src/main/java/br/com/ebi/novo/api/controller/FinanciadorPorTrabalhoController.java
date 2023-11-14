package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.controller.openapi.FinanciadorPorTrabalhoControllerOpenApi;
import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import br.com.ebi.novo.api.service.IFinanciadorPorTrabalhoService;
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
public class FinanciadorPorTrabalhoController implements FinanciadorPorTrabalhoControllerOpenApi {

    private final IFinanciadorPorTrabalhoService financiadorPorTrabalhoService;

    @GetMapping("/{idTrabalho}")
    public ResponseEntity<List<FinanciadorResponse>> filtrarFinanciadoresPorTrabalho(@PathVariable Integer idTrabalho) {
        List<FinanciadorResponse> financiadores = financiadorPorTrabalhoService.filtrarFinanciadoresPorTrabalho(idTrabalho);
        return ResponseEntity.ok().body(financiadores);
    }

}
