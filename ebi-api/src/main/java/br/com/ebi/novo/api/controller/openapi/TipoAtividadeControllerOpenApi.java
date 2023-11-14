package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.dto.response.TipoAtividadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "TipoAtividades")
public interface TipoAtividadeControllerOpenApi {

    @Operation(summary = "Listar todas os tipos de atividades")
    @ApiResponse(responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TipoAtividadeResponse.class))))
    ResponseEntity<List<TipoAtividadeResponse>> listarTodos();

    @Operation(summary = "Buscar um tipo de atividade por ID")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TipoAtividadeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tipo atividade não encontrada")
    ResponseEntity<TipoAtividadeResponse> buscarPorId(Integer idTipo);

    @Operation(summary = "Cadastrar uma novo tipo de atividade")
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = TipoAtividadeResponse.class)))
    ResponseEntity<TipoAtividadeResponse> cadastrar(TipoAtividadeRequest request);

    @Operation(summary = "Editar um tipo de atividade existente")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = TipoAtividadeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Tipo de atividade não encontrada")
    ResponseEntity<TipoAtividadeResponse> editar(Integer idTipo, TipoAtividadeRequest request);

    @Operation(summary = "Excluir um tipo de atividade por ID")
    @ApiResponse(responseCode = "204", description = "Atividade excluída com sucesso")
    @ApiResponse(responseCode = "404", description = "Tipo de atividade não encontrada")
    ResponseEntity<Void> excluir(Integer idTipo);

}
