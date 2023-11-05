package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.request.TrabalhoRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
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
        Trabalho trabalho = new Trabalho();
        trabalho.setTitulo(request.getTitulo());
        trabalho.setResumo(request.getResumo());
        trabalho.setPalavrasChave(request.getPalavrasChave());
        trabalho.setAtividade(atividadeMapper.toEntity(request.getAtividade()));
        return trabalho;
    }

    @Override
    public TrabalhoResponse toResponse(Trabalho entity) {
        TrabalhoResponse response = new TrabalhoResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getTitulo());
        response.setPalavrasChave(entity.getPalavrasChave());
        response.setResumo(entity.getResumo());
        return response;
    }

    @Override
    public List<TrabalhoResponse> toList(List<Trabalho> entities) {
        return entities.stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public Trabalho responseToEntity(TrabalhoResponse response) {
        Trabalho trabalho = new Trabalho();
        trabalho.setId(response.getId());
        trabalho.setTitulo(response.getTitulo());
        trabalho.setPalavrasChave(response.getPalavrasChave());
        trabalho.setResumo(response.getResumo());
        return trabalho;
    }

}
