package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.exception.AtividadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import br.edu.ufra.novo.ebi.repository.IAtividadeRepository;
import br.edu.ufra.novo.ebi.service.base.IBaseService;
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
