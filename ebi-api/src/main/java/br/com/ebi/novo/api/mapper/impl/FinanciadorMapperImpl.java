package br.com.ebi.novo.api.mapper.impl;

import br.com.ebi.novo.api.builder.FinanciadorBuilder;
import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.dto.request.FinanciadorRequest;
import br.com.ebi.novo.api.entity.Financiador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FinanciadorMapperImpl implements IBaseMapper<Financiador, FinanciadorRequest, FinanciadorResponse> {

    @Override
    public Financiador toEntity(FinanciadorRequest request) {
        return FinanciadorBuilder.builder()
                .nome(request.getNome())
                .build();
    }

    @Override
    public FinanciadorResponse toResponse(Financiador entity) {
        return FinanciadorResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }

    @Override
    public List<FinanciadorResponse> toList(List<Financiador> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Financiador responseToEntity(FinanciadorResponse response) {
        return FinanciadorBuilder.builder()
                .id(response.getId())
                .nome(response.getNome())
                .build();
    }
}
