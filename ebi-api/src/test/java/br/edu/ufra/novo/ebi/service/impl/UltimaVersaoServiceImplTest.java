package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.response.UltimaVersaoResponse;
import br.edu.ufra.novo.ebi.repository.IVersaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UltimaVersaoServiceImplTest {

    @InjectMocks
    private UltimaVersaoServiceImpl ultimaVersaoService;
    @Mock
    private IVersaoRepository versaoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

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