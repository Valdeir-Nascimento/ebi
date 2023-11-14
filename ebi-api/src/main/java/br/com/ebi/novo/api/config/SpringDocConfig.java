package br.com.ebi.novo.api.config;

import br.com.ebi.novo.api.exception.handler.Field;
import br.com.ebi.novo.api.exception.handler.Problem;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciamento de Produtos API")
                        .version("v1")
                        .description("API que faz gerencimento de estoque de produtos")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.com")
                        )
                ).externalDocs(new ExternalDocumentation()
                        .description("EBI")
                        .url("https://ebi.com.br")
                ).tags(
                    Arrays.asList(
                        new Tag().name("Atividades").description("Gerencia as atividades"),
                        new Tag().name("TipoAtividades").description("Gerencia os tipos de atividades"),
                        new Tag().name("Autores").description("Gerencia os autores"),
                        new Tag().name("Financiadores").description("Gerencia os financiadores"),
                        new Tag().name("Palestrantes").description("Gerencia os palestrantes"),
                        new Tag().name("Versões").description("Gerencia as versões")
                    )
                )
                .components(new Components().schemas(gerarSchemas()));
    }

    private Map<String, Schema> gerarSchemas() {
        final Map<String, Schema> schemaMap = new HashMap<>();
        Map<String, Schema> problemSchema = ModelConverters.getInstance().read(Problem.class);
        Map<String, Schema> problemObjectSchema = ModelConverters.getInstance().read(Field.class);
        schemaMap.putAll(problemSchema);
        schemaMap.putAll(problemObjectSchema);
        return schemaMap;
    }

}
