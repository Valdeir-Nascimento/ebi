package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.response.UltimaVersaoResponse;
import br.edu.ufra.novo.ebi.repository.IVersaoRepository;
import br.edu.ufra.novo.ebi.service.IUltimaVersaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UltimaVersaoServiceImpl implements IUltimaVersaoService {

    private final IVersaoRepository versaoRepository;

    @Override
    public UltimaVersaoResponse getVersao() {
        Integer versao = versaoRepository.ultimaVersao();
        return new UltimaVersaoResponse(versao);
    }

}
