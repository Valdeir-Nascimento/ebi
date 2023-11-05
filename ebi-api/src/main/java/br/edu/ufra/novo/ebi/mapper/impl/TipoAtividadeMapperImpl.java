package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoAtividadeMapperImpl implements IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> {

    @Override
    public TipoAtividade toEntity(TipoAtividadeRequest request) {
        return new TipoAtividade(request.getNome(), request.getListarPalestrantes());
    }

    @Override
    public TipoAtividadeResponse toResponse(TipoAtividade entity) {
        return new TipoAtividadeResponse(entity.getId(), entity.getNome(), entity.getListarPalestrantes());
    }

    @Override
    public List<TipoAtividadeResponse> toList(List<TipoAtividade> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public TipoAtividade responseToEntity(TipoAtividadeResponse response) {
        TipoAtividade tipo = new TipoAtividade();
        tipo.setId(response.getId());
        tipo.setNome(response.getNome());
        tipo.setListarPalestrantes(response.getListarPalestrantes());
        return tipo;
    }

}
