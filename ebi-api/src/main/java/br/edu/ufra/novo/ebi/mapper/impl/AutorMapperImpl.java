package br.edu.ufra.novo.ebi.mapper.impl;

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
        return new Autor(request.getNome(), request.getAbreviado(), request.getInstituicao());
    }

    @Override
    public AutorResponse toResponse(Autor entity) {
        return new AutorResponse(entity.getId(), entity.getNome(), entity.getAbreviado(), entity.getInstituicao());
    }

    @Override
    public List<AutorResponse> toList(List<Autor> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Autor responseToEntity(AutorResponse response) {
        return null;
    }

}
