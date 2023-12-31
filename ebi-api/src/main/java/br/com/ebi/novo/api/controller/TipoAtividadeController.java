package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.controller.openapi.TipoAtividadeControllerOpenApi;
import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;
import br.com.ebi.novo.api.dto.response.TipoAtividadeResponse;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tipo-atividade")
public class TipoAtividadeController implements TipoAtividadeControllerOpenApi {

    private final IBaseService<TipoAtividadeRequest, TipoAtividadeResponse> tipoAtividadeService;

    @GetMapping
    public ResponseEntity<List<TipoAtividadeResponse>> listarTodos() {
        List<TipoAtividadeResponse> atividades = tipoAtividadeService.listarTodos();
        return ResponseEntity.ok().body(atividades);
    }

    @GetMapping("/{idTipo}")
    public ResponseEntity<TipoAtividadeResponse> buscarPorId(@PathVariable Integer idTipo) {
        TipoAtividadeResponse response = tipoAtividadeService.buscarPorId(idTipo);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<TipoAtividadeResponse> cadastrar(@Valid @RequestBody TipoAtividadeRequest request) {
        TipoAtividadeResponse response = tipoAtividadeService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{idTipo}")
    public ResponseEntity<TipoAtividadeResponse> editar(@PathVariable Integer idTipo, @Valid @RequestBody TipoAtividadeRequest request) {
        TipoAtividadeResponse response = tipoAtividadeService.editar(idTipo, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{idTipo}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idTipo) {
        tipoAtividadeService.excluir(idTipo);
        return ResponseEntity.noContent().build();
    }

}
