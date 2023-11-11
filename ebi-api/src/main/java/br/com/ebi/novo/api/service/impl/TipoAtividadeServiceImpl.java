package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.request.TipoAtividadeRequest;
import br.com.ebi.novo.api.dto.response.TipoAtividadeResponse;
import br.com.ebi.novo.api.entity.TipoAtividade;
import br.com.ebi.novo.api.exception.TipoAtividadeNaoEncontradaException;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mapper.IPropertyCopier;
import br.com.ebi.novo.api.repository.ITipoAtividadeRepository;
import br.com.ebi.novo.api.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TipoAtividadeServiceImpl implements IBaseService<TipoAtividadeRequest, TipoAtividadeResponse> {

    private final ITipoAtividadeRepository tipoAtividadeRepository;
    private final IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> mapper;
    private final IPropertyCopier<TipoAtividadeRequest, TipoAtividade> propertyCopier;

    @Override
    public List<TipoAtividadeResponse> listarTodos() {
        List<TipoAtividade> atividades = tipoAtividadeRepository.findAll();
        return mapper.toList(atividades);
    }

    @Override
    public TipoAtividadeResponse buscarPorId(Integer id) {
        TipoAtividade tipoAtividade = tipoAtividadeRepository.findById(id)
                .orElseThrow(() -> new TipoAtividadeNaoEncontradaException(id));
        return mapper.toResponse(tipoAtividade);
    }

    @Override
    public TipoAtividadeResponse cadastrar(TipoAtividadeRequest request) {
        TipoAtividade tipoAtividade = mapper.toEntity(request);
        tipoAtividade = tipoAtividadeRepository.save(tipoAtividade);
        return mapper.toResponse(tipoAtividade);
    }

    @Override
    public TipoAtividadeResponse editar(Integer id, TipoAtividadeRequest request) {
        TipoAtividadeResponse response = buscarPorId(id);
        TipoAtividade tipoAtividade = mapper.responseToEntity(response);
        propertyCopier.copyProperties(request, tipoAtividade);
        tipoAtividade = tipoAtividadeRepository.save(tipoAtividade);
        return mapper.toResponse(tipoAtividade);
    }

    @Override
    public void excluir(Integer id) {
        try {
            tipoAtividadeRepository.deleteById(id);
            tipoAtividadeRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new TipoAtividadeNaoEncontradaException(id);
        }
    }

}
