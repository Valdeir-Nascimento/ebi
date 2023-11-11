package br.com.ebi.novo.api.mapper.impl;

import br.com.ebi.novo.api.builder.TipoAtividadeBuilder;
import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;
import br.com.ebi.novo.api.dto.response.TipoAtividadeResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.entity.TipoAtividade;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoAtividadeMapperImpl implements IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> {

    @Override
    public TipoAtividade toEntity(TipoAtividadeRequest request) {
        return TipoAtividadeBuilder.builder()
                .nome(request.getNome())
                .listarPalestrantes(request.getListarPalestrantes())
                .build();
    }

    @Override
    public TipoAtividadeResponse toResponse(TipoAtividade entity) {
        return TipoAtividadeResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .listarPalestrantes(entity.getListarPalestrantes())
                .build();
    }

    @Override
    public List<TipoAtividadeResponse> toList(List<TipoAtividade> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public TipoAtividade responseToEntity(TipoAtividadeResponse response) {
        return TipoAtividadeBuilder.builder()
                .id(response.getId())
                .nome(response.getNome())
                .listarPalestrantes(response.getListarPalestrantes())
                .build();
    }

}
