package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.dto.request.FinanciadorRequest;
import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/financiadores")
public class FinanciadorController {
    
    private final IBaseService<FinanciadorRequest, FinanciadorResponse> financiadorService;

    @GetMapping
    public ResponseEntity<List<FinanciadorResponse>> listarTodos() {
        List<FinanciadorResponse> atividades = financiadorService.listarTodos();
        return ResponseEntity.ok().body(atividades);
    }

    @GetMapping("/{idFinanciador}")
    public ResponseEntity<FinanciadorResponse> buscarPorId(@PathVariable Integer idFinanciador) {
        FinanciadorResponse response = financiadorService.buscarPorId(idFinanciador);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<FinanciadorResponse> cadastrar(@Valid @RequestBody FinanciadorRequest request) {
        FinanciadorResponse response = financiadorService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{idFinanciador}")
    public ResponseEntity<FinanciadorResponse> editar(@PathVariable Integer idFinanciador, @Valid @RequestBody FinanciadorRequest request) {
        FinanciadorResponse response = financiadorService.editar(idFinanciador, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{idFinanciador}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idFinanciador) {
        financiadorService.excluir(idFinanciador);
        return ResponseEntity.noContent().build();
    }
    
}
