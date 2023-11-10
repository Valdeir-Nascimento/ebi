package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.builder.AutorBuilder;
import br.edu.ufra.novo.ebi.dto.request.AutorRequest;
import br.edu.ufra.novo.ebi.dto.response.AutorResponse;
import br.edu.ufra.novo.ebi.entity.Autor;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
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
