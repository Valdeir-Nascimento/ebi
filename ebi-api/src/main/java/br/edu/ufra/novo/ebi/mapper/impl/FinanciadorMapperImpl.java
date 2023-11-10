package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.builder.FinanciadorBuilder;
import br.edu.ufra.novo.ebi.dto.request.FinanciadorRequest;
import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;
import br.edu.ufra.novo.ebi.entity.Financiador;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
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
