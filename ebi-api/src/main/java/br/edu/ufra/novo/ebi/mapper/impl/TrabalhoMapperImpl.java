package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.builder.TrabalhoBuilder;
import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.request.TrabalhoRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrabalhoMapperImpl implements IBaseMapper<Trabalho, TrabalhoRequest, TrabalhoResponse> {

    private final IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> atividadeMapper;

    @Override
    public Trabalho toEntity(TrabalhoRequest request) {
        return TrabalhoBuilder.builder()
                .titulo(request.getTitulo())
                .resumo(request.getResumo())
                .palavrasChave(request.getPalavrasChave())
                .atividade(atividadeMapper.toEntity(request.getAtividade()))
                .build();
    }

    @Override
    public TrabalhoResponse toResponse(Trabalho entity) {
        AtividadeResponse atividade = AtividadeResponse.builder()
                .id(entity.getAtividade().getId())
                .nome(entity.getAtividade().getNome())
                .inicio(DataUtil.formatInstant(entity.getAtividade().getInicio()))
                .fim(DataUtil.formatInstant(entity.getAtividade().getFim()))
                .resumo(entity.getAtividade().getResumo())
                .build();

        return TrabalhoResponse.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .resumo(entity.getResumo())
                .palavrasChave(entity.getPalavrasChave())
                .atividade(atividade)
                .build();
    }

    @Override
    public List<TrabalhoResponse> toList(List<Trabalho> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Trabalho responseToEntity(TrabalhoResponse response) {
        return TrabalhoBuilder.builder()
                .id(response.getId())
                .titulo(response.getTitulo())
                .palavrasChave(response.getPalavrasChave())
                .resumo(response.getResumo())
                .build();
    }

}
