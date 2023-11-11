package br.com.ebi.novo.api.mapper.impl;

import br.com.ebi.novo.api.builder.AutorBuilder;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.dto.request.AutorRequest;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import br.com.ebi.novo.api.entity.Autor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutorMapperImpl implements IBaseMapper<Autor, AutorRequest, AutorResponse> {

    @Override
    public Autor toEntity(AutorRequest request) {
        return AutorBuilder.builder()
                .nome(request.getNome())
                .abreviado(request.getAbreviado())
                .instituicao(request.getInstituicao())
                .build();
    }

    @Override
    public AutorResponse toResponse(Autor entity) {
        return AutorResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .abreviado(entity.getAbreviado())
                .instituicao(entity.getInstituicao())
                .build();
    }

    @Override
    public List<AutorResponse> toList(List<Autor> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Autor responseToEntity(AutorResponse response) {
        return AutorBuilder.builder()
                .id(response.getId())
                .nome(response.getNome())
                .abreviado(response.getAbreviado())
                .instituicao(response.getInstituicao())
                .build();
    }

}
