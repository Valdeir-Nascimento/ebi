package br.edu.ufra.novo.ebi.controller;

import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tipo-atividade")
public class TipoAtividadeController {

    private final IBaseService<TipoAtividadeRequest, TipoAtividadeResponse> tipoAtividadeService;

    @GetMapping
    public ResponseEntity<List<TipoAtividadeResponse>> listarToodos() {
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
