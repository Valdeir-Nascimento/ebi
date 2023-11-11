package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.exception.AtividadeNaoEncontradaException;
import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mapper.IPropertyCopier;
import br.com.ebi.novo.api.repository.IAtividadeRepository;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadeServiceImpl implements IBaseService<AtividadeRequest, AtividadeResponse> {

    private final IAtividadeRepository atividadeRepository;
    private final IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> mapper;
    private final IPropertyCopier<AtividadeRequest, Atividade> propertyCopier;

    @Override
    public List<AtividadeResponse> listarTodos() {
        List<Atividade> atividades = atividadeRepository.findAll();
        return mapper.toList(atividades);
    }

    @Override
    public AtividadeResponse buscarPorId(Integer id) {
        Atividade atividade = atividadeRepository.findById(id)
                .orElseThrow(() -> new AtividadeNaoEncontradaException(id));
        return mapper.toResponse(atividade);
    }

    @Override
    public AtividadeResponse cadastrar(AtividadeRequest request) {
        Atividade atividade = mapper.toEntity(request);
        atividade = atividadeRepository.save(atividade);
        return mapper.toResponse(atividade);
    }

    @Override
    public AtividadeResponse editar(Integer id, AtividadeRequest request) {
        AtividadeResponse response = buscarPorId(id);
        Atividade atividade = mapper.responseToEntity(response);
        propertyCopier.copyProperties(request, atividade);
        atividade = atividadeRepository.save(atividade);
        return mapper.toResponse(atividade);
    }

    @Override
    public void excluir(Integer id) {
        try {
            atividadeRepository.deleteById(id);
            atividadeRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new AtividadeNaoEncontradaException(id);
        }
    }
}
