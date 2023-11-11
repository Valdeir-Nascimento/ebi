package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.service.IPalestranteService;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/palestrantes")
public class PalestranteController {

    private final IPalestranteService palestranteService;

    @GetMapping
    public ResponseEntity<List<AutorResponse>> filtrarPalestrantes() {
        List<AutorResponse> palestrantes = palestranteService.filtrarPalestrantes();
        return ResponseEntity.ok().body(palestrantes);
    }

}
