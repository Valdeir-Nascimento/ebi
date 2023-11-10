package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.response.UltimaVersaoResponse;
import br.edu.ufra.novo.ebi.repository.IVersaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UltimaVersaoServiceImplTest {

    @InjectMocks
    private UltimaVersaoServiceImpl ultimaVersaoService;
    @Mock
    private IVersaoRepository versaoRepository;

    @Test
    void dadoUmaVersaoValidaQuandoBuscarUltimaVersaoEntaoDeveRetornarVersaoAtual() {
        Integer ultimaVersao = 3;
        when(versaoRepository.ultimaVersao()).thenReturn(ultimaVersao);
        UltimaVersaoResponse versaoAtual = ultimaVersaoService.getVersao();
        verify(versaoRepository).ultimaVersao();
        assertEquals(ultimaVersao, versaoAtual.getUltimaVersao());
    }

    @Test
    void dadoUmaVersaoInvalidaQuandoBuscarUltimaVersaoEntaoDeveRetornarNulo() {
        when(versaoRepository.ultimaVersao()).thenReturn(null);
        UltimaVersaoResponse versaoAtual = ultimaVersaoService.getVersao();
        verify(versaoRepository).ultimaVersao();
        assertNull(versaoAtual.getUltimaVersao());
    }

}