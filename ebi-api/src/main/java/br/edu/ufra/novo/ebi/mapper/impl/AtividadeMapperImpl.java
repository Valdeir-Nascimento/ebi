package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.builder.AtividadeBuilder;
import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.request.SalaRequest;
import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.SalaResponse;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.util.DataUtil;
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
