package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.request.FinanciadorRequest;
import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Financiadores")
public interface FinanciadorControllerOpenApi {

    @Operation(summary = "Listar todas os financiadores")
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = FinanciadorResponse.class))))
    ResponseEntity<List<FinanciadorResponse>> listarTodos();

    @Operation(summary = "Buscar um financiador por ID")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = FinanciadorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Financiador não encontrado")
    ResponseEntity<FinanciadorResponse> buscarPorId(Integer idFinanciador);

    @Operation(summary = "Cadastrar um novo financiador")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = FinanciadorResponse.class)))
    ResponseEntity<FinanciadorResponse> cadastrar(FinanciadorRequest request);

    @Operation(summary = "Editar um financiador existente")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = FinanciadorResponse.class)))
    @ApiResponse(responseCode = "404", description = "Financiador não encontrado")
    ResponseEntity<FinanciadorResponse> editar(Integer idFinanciador, FinanciadorRequest request);

    @Operation(summary = "Excluir um financiador por ID")
    @ApiResponse(responseCode = "204", description = "Financiador excluído com sucesso")
    @ApiResponse(responseCode = "404", description = "Financiador não encontrado")
    ResponseEntity<Void> excluir(Integer idFinanciador);

}
