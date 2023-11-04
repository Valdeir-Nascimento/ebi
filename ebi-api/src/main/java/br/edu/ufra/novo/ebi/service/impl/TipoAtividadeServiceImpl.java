package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.exception.TipoAtividadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.ITipoAtividadeRepository;
import br.edu.ufra.novo.ebi.service.ITipoAtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoAtividadeServiceImpl implements ITipoAtividadeService {

    private final ITipoAtividadeRepository tipoAtividadeRepository;
    private final IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> mapper;

    @Override
    public TipoAtividadeResponse buscarPorId(Integer idTipoAtividade) {
        TipoAtividade tipoAtividade = tipoAtividadeRepository.findById(idTipoAtividade)
            .orElseThrow(() -> new TipoAtividadeNaoEncontradaException(idTipoAtividade));
        return mapper.toResponse(tipoAtividade);

    }
}
