package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.service.IUltimaVersaoService;
import br.com.ebi.novo.api.dto.response.UltimaVersaoResponse;
import br.com.ebi.novo.api.repository.IVersaoRepository;
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
