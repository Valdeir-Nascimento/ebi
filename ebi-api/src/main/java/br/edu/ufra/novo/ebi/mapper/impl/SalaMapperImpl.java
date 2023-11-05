package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.dto.request.SalaRequest;
import br.edu.ufra.novo.ebi.dto.response.SalaResponse;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SalaMapperImpl implements IBaseMapper<Sala, SalaRequest, SalaResponse> {

    @Override
    public Sala toEntity(SalaRequest request) {
        return new Sala(request.getNome(), request.getImagem());
    }

    @Override
    public SalaResponse toResponse(Sala entity) {
        return new SalaResponse(entity.getId(), entity.getNome(), entity.getImagem());
    }

    @Override
    public List<SalaResponse> toList(List<Sala> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Sala responseToEntity(SalaResponse response) {
        return null;
    }

}
