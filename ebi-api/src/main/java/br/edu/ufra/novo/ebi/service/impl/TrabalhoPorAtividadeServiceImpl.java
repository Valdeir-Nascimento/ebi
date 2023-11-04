package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.TrabalhoRequest;
import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.ITrabalhoRepository;
import br.edu.ufra.novo.ebi.service.ITrabalhoPorAtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabalhoPorAtividadeServiceImpl implements ITrabalhoPorAtividadeService {

    private final ITrabalhoRepository trabalhoRepository;
    private final IBaseMapper<Trabalho, TrabalhoRequest, TrabalhoResponse> mapper;

    @Override
    public List<TrabalhoResponse> filtrarTrbalhosPorAtividade(Integer idAtividade) {
        List<Trabalho> trabalhos = trabalhoRepository.filtrarTrbalhosPorAtividade(idAtividade);
        return mapper.toList(trabalhos);
    }

}
