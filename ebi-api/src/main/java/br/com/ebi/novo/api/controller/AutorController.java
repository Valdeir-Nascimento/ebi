package br.com.ebi.novo.api.controller;

import br.com.ebi.novo.api.dto.request.AutorRequest;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/autores")
public class AutorController {
    
    private final IBaseService<AutorRequest, AutorResponse> autorService;

    @GetMapping
    public ResponseEntity<List<AutorResponse>> listarTodos() {
        List<AutorResponse> atividades = autorService.listarTodos();
        return ResponseEntity.ok().body(atividades);
    }

    @GetMapping("/{idAutor}")
    public ResponseEntity<AutorResponse> buscarPorId(@PathVariable Integer idAutor) {
        AutorResponse response = autorService.buscarPorId(idAutor);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@Valid @RequestBody AutorRequest request) {
        AutorResponse response = autorService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{idAutor}")
    public ResponseEntity<AutorResponse> editar(@PathVariable Integer idAutor, @Valid @RequestBody AutorRequest request) {
        AutorResponse response = autorService.editar(idAutor, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{idAutor}")
    public ResponseEntity<Void> excluir(@PathVariable Integer idAutor) {
        autorService.excluir(idAutor);
        return ResponseEntity.noContent().build();
    }

}
