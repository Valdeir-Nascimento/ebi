package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Atividades")
public interface AtividadeControllerOpenApi {

    @Operation(summary = "Listar todas as atividades")
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AtividadeResponse.class))))
    ResponseEntity<List<AtividadeResponse>> listarTodos();

    @Operation(summary = "Buscar uma atividade por ID")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AtividadeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    ResponseEntity<AtividadeResponse> buscarPorId(Integer idAtividade);

    @Operation(summary = "Cadastrar uma nova atividade")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = AtividadeResponse.class)))
    ResponseEntity<AtividadeResponse> cadastrar(AtividadeRequest request);

    @Operation(summary = "Editar uma atividade existente")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AtividadeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    ResponseEntity<AtividadeResponse> editar(Integer idAtividade, AtividadeRequest request);

    @Operation(summary = "Excluir uma atividade por ID")
    @ApiResponse(responseCode = "204", description = "Atividade excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    ResponseEntity<Void> excluir(Integer idAtividade);

}
