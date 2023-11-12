package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.response.VersaoResponse;
import br.com.ebi.novo.api.entity.Versao;
import br.com.ebi.novo.api.repository.IVersaoRepository;
import br.com.ebi.novo.api.service.IAtualizarVersao;
import br.com.ebi.novo.api.util.DataUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AtualizarVersaoImpl implements IAtualizarVersao {

    private final IVersaoRepository versaoRepository;

    @Override
    public VersaoResponse atualizar() {
        Versao novaVersao = new Versao();
        novaVersao.setUltima(Instant.now());
        novaVersao = versaoRepository.save(novaVersao);
        return VersaoResponse.builder()
                .id(novaVersao.getId())
                .ultima(DataUtil.formatInstant(novaVersao.getUltima()))
                .build();
    }

}
