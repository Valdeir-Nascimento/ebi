package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.request.AutorRequest;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Autores")
public interface AutorControllerOpenApi {

    @Operation(summary = "Listar todas os autores")
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AutorResponse.class))))
    ResponseEntity<List<AutorResponse>> listarTodos();

    @Operation(summary = "Buscar um autor por ID")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AutorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    ResponseEntity<AutorResponse> buscarPorId(Integer idAutor);

    @Operation(summary = "Cadastrar uma novo autor")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = AutorResponse.class)))
    ResponseEntity<AutorResponse> cadastrar(AutorRequest request);

    @Operation(summary = "Editar um autor existente")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AutorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    ResponseEntity<AutorResponse> editar(Integer idAutor, AutorRequest request);

    @Operation(summary = "Excluir um financiador por ID")
    @ApiResponse(responseCode = "204", description = "Autor excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    ResponseEntity<Void> excluir(Integer idAutor);

}
