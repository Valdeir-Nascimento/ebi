package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.response.TrabalhoResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.repository.ITrabalhoRepository;
import br.com.ebi.novo.api.dto.request.TrabalhoRequest;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.entity.Trabalho;
import br.com.ebi.novo.api.service.ITrabalhoPorAtividadeService;
import br.com.ebi.novo.api.service.base.validator.IValidarExistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabalhoPorAtividadeServiceImpl implements ITrabalhoPorAtividadeService {

    private final ITrabalhoRepository trabalhoRepository;
    private final IBaseMapper<Trabalho, TrabalhoRequest, TrabalhoResponse> mapper;
    private final IValidarExistenciaService<Atividade, Integer> validarExistenciaService;

    @Override
    public List<TrabalhoResponse> filtrarTrbalhosPorAtividade(Integer idAtividade) {
        validarExistenciaService.validar(idAtividade);
        List<Trabalho> trabalhos = trabalhoRepository.filtrarTrbalhosPorAtividade(idAtividade);
        return mapper.toList(trabalhos);
    }

}
