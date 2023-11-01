package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.repository.IAtividadeRepository;
import br.edu.ufra.novo.ebi.service.IAtividadePorTipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtividadePorTipoServiceImpl implements IAtividadePorTipoService {

    private final IAtividadeRepository atividadeRepository;

    @Override
    public List<Atividade> filtrarAtividadesPorTipo(TipoAtividade tipo) {
        return atividadeRepository.filtrarAtividadesPorTipo(tipo);
    }

}
