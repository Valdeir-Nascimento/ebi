package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.builder.TipoAtividadeBuilder;
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
