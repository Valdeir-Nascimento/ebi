package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.controller.openapi.VersaoControllerOpenApi;
import br.com.ebi.novo.api.service.IUltimaVersaoService;
import br.com.ebi.novo.api.dto.response.UltimaVersaoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/versoes")
public class VersaoController implements VersaoControllerOpenApi {

    private final IUltimaVersaoService ultimaVersaoService;

    @GetMapping
    public ResponseEntity<UltimaVersaoResponse> ultimaVersao() {
        UltimaVersaoResponse versao = ultimaVersaoService.getVersao();
        return ResponseEntity.ok().body(versao);
    }

}
