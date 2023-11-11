package br.com.ebi.novo.api.mapper.impl;

import br.com.ebi.novo.api.builder.SalaBuilder;
import br.com.ebi.novo.api.dto.request.SalaRequest;
import br.com.ebi.novo.api.dto.response.SalaResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.entity.Sala;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SalaMapperImpl implements IBaseMapper<Sala, SalaRequest, SalaResponse> {

    @Override
    public Sala toEntity(SalaRequest request) {
        return SalaBuilder.builder()
                .nome(request.getNome())
                .imagem(request.getImagem())
                .build();
    }

    @Override
    public SalaResponse toResponse(Sala entity) {
        return SalaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .imagem(entity.getImagem())
                .build();
    }

    @Override
    public List<SalaResponse> toList(List<Sala> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Sala responseToEntity(SalaResponse response) {
        return SalaBuilder.builder()
                .id(response.getId())
                .nome(response.getNome())
                .imagem(response.getImagem())
                .build();
    }

}
