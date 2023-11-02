package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IAtividadeRepository;
import br.edu.ufra.novo.ebi.service.IAtividadePorTipoService;
import br.edu.ufra.novo.ebi.service.validator.IValidarExistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadePorTipoServiceImpl implements IAtividadePorTipoService {

    private final IAtividadeRepository atividadeRepository;
    private final IValidarExistenciaService<TipoAtividade, Integer> validarExistenciaService;
    private final IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> mapper;

    @Override
    public List<AtividadeResponse> filtrarAtividadesPorTipo(Integer idTipoAtividade) {
        validarExistenciaService.validar(idTipoAtividade);
        List<Atividade> atividades = atividadeRepository.filtrarAtividadesPorTipo(idTipoAtividade);
        return mapper.toList(atividades, AtividadeResponse.class);
    }

}
