package br.com.ebi.novo.api.controller.openapi;

import br.com.ebi.novo.api.dto.response.AutorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Palestrantes")
public interface PalestranteControllerOpenApi {

    @Operation(summary = "Filtrar palestrantes")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Palestrantes filtrados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AutorResponse.class))))
    })
     ResponseEntity<List<AutorResponse>> filtrarPalestrantes();

}
