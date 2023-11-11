package br.com.ebi.novo.api.mapper.impl;

import br.com.ebi.novo.api.builder.AtividadeBuilder;
import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.dto.request.SalaRequest;
import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.dto.response.SalaResponse;
import br.com.ebi.novo.api.dto.response.TipoAtividadeResponse;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.entity.Sala;
import br.com.ebi.novo.api.entity.TipoAtividade;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AtividadeMapperImpl implements IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> {

    private final IBaseMapper<Sala, SalaRequest, SalaResponse> salaMapper;
    private final IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> tipoAtividadeMapper;

    @Override
    public Atividade toEntity(AtividadeRequest request) {
        return AtividadeBuilder.builder()
                .nome(request.getNome())
                .resumo(request.getResumo())
                .inicio(DataUtil.convertStringToInstant(request.getInicio()))
                .fim(DataUtil.convertStringToInstant(request.getFim()))
                .tipoAtividade(tipoAtividadeMapper.toEntity(request.getTipo()))
                .sala(salaMapper.toEntity(request.getSala()))
                .build();
    }

    @Override
    public AtividadeResponse toResponse(Atividade entity) {
        return AtividadeResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .resumo(entity.getResumo())
                .inicio(DataUtil.formatInstant(entity.getInicio()))
                .fim(DataUtil.formatInstant(entity.getFim()))
                .tipoAtividade(tipoAtividadeMapper.toResponse(entity.getTipoAtividade()))
                .sala(salaMapper.toResponse(entity.getSala()))
                .build();
    }

    @Override
    public List<AtividadeResponse> toList(List<Atividade> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Atividade responseToEntity(AtividadeResponse response) {
        return AtividadeBuilder.builder()
                .id(response.getId())
                .nome(response.getNome())
                .resumo(response.getResumo())
                .inicio(DataUtil.convertStringToInstant(response.getInicio()))
                .fim(DataUtil.convertStringToInstant(response.getFim()))
                .tipoAtividade(tipoAtividadeMapper.responseToEntity(response.getTipoAtividade()))
                .sala(salaMapper.responseToEntity(response.getSala()))
                .build();
    }

}
