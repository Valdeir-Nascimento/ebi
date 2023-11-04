package br.edu.ufra.novo.ebi.mapper.impl;

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
        Atividade atividade = new Atividade();
        atividade.setNome(request.getNome());
        atividade.setResumo(request.getResumo());
        atividade.setInicio(DataUtil.convertStringToInstant(request.getInicio()));
        atividade.setFim(DataUtil.convertStringToInstant(request.getFim()));
        atividade.setTipoAtividade(tipoAtividadeMapper.toEntity(request.getTipo()));
        atividade.setSala(salaMapper.toEntity(request.getSala()));
        return atividade;
    }

    @Override
    public AtividadeResponse toResponse(Atividade entity) {
        AtividadeResponse response = new AtividadeResponse();
        response.setId(entity.getId());
        response.setNome(entity.getNome());
        response.setResumo(entity.getResumo());
        response.setInicio(DataUtil.formatInstant(entity.getInicio()));
        response.setFim(DataUtil.formatInstant(entity.getFim()));
        response.setTipoAtividade(tipoAtividadeMapper.toResponse(entity.getTipoAtividade()));
        response.setSala(salaMapper.toResponse(entity.getSala()));
        return response;
    }

    @Override
    public List<AtividadeResponse> toList(List<Atividade> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

}
