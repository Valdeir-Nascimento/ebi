package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.response.UltimaVersaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Versões")
public interface VersaoControllerOpenApi {

    @Operation(summary = "Obter a última versão")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Última versão obtida com sucesso",
            content = @Content(schema = @Schema(implementation = UltimaVersaoResponse.class)))
    })
    ResponseEntity<UltimaVersaoResponse> ultimaVersao();

}
