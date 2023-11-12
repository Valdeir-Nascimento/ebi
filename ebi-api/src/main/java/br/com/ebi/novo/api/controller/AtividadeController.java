package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/atividades")
public class AtividadeController {

    private final IBaseService<AtividadeRequest, AtividadeResponse> atividadeService;

    @GetMapping
    public ResponseEntity<List<AtividadeResponse>> listarTodos() {
        List<AtividadeResponse> atividades = atividadeService.listarTodos();
        return ResponseEntity.ok().body(atividades);
    }

    @GetMapping("/{idAtividade}")
    public ResponseEntity<AtividadeResponse> buscarPorId(@PathVariable Integer idAtividade) {
        AtividadeResponse response = atividadeService.buscarPorId(idAtividade);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<AtividadeResponse> cadastrar(@Valid @RequestBody AtividadeRequest request) {
        AtividadeResponse response = atividadeService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{idAtividade}")
    public ResponseEntity<AtividadeResponse> editar(@PathVariable Integer idAtividade, @Valid @RequestBody AtividadeRequest request) {
        AtividadeResponse response = atividadeService.editar(idAtividade, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{idAtividade}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idAtividade) {
        atividadeService.excluir(idAtividade);
        return ResponseEntity.noContent().build();
    }


}
