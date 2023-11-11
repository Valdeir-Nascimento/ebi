package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.repository.IAtividadeRepository;
import br.com.ebi.novo.api.service.IAtividadePorTipoService;
import br.com.ebi.novo.api.service.base.validator.IValidarExistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadePorTipoServiceImpl implements IAtividadePorTipoService {

    private final IAtividadeRepository atividadeRepository;
    private final IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> mapper;
    private final IValidarExistenciaService<Atividade, Integer> validarExistenciaService;

    @Override
    public List<AtividadeResponse> filtrarAtividadesPorTipo(Integer idTipoAtividade) {
        validarExistenciaService.validar(idTipoAtividade);
        List<Atividade> atividades = atividadeRepository.filtrarAtividadesPorTipo(idTipoAtividade);
        return mapper.toList(atividades);
    }

}
