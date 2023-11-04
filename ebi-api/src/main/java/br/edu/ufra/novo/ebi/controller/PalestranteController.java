package br.edu.ufra.novo.ebi.controller;

import br.edu.ufra.novo.ebi.dto.response.AutorResponse;
import br.edu.ufra.novo.ebi.service.IPalestranteService;
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
        List<AutorResponse> palestrantes = palestranteService.obterPalestrantes();
        return ResponseEntity.ok().body(palestrantes);
    }

}
