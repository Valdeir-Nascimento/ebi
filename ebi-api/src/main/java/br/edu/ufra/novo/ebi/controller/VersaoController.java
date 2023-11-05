package br.edu.ufra.novo.ebi.controller;

import br.edu.ufra.novo.ebi.dto.response.UltimaVersaoResponse;
import br.edu.ufra.novo.ebi.service.IUltimaVersaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/versoes")
public class VersaoController {

    private final IUltimaVersaoService ultimaVersaoService;

    @GetMapping
    public ResponseEntity<UltimaVersaoResponse> ultimaVersao() {
        UltimaVersaoResponse versao = ultimaVersaoService.getVersao();
        return ResponseEntity.ok().body(versao);
    }

}
