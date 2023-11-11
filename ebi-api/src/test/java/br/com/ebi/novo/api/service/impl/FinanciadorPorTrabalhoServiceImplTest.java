package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mock.entity.FinanciadorMock;
import br.com.ebi.novo.api.repository.IFinanciadorRepository;
import br.com.ebi.novo.api.dto.request.FinanciadorRequest;
import br.com.ebi.novo.api.entity.Financiador;
import br.com.ebi.novo.api.entity.Trabalho;
import br.com.ebi.novo.api.exception.EntidadeNaoEncontradaException;
import br.com.ebi.novo.api.mock.dto.response.FinanciadorResponseMock;
import br.com.ebi.novo.api.service.base.validator.IValidarExistenciaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FinanciadorPorTrabalhoServiceImplTest {

    @InjectMocks
    private FinanciadorPorTrabalhoServiceImpl financiadorPorTrabalhoService;
    @Mock
    private IFinanciadorRepository financiadorRepository;
    @Mock
    private IBaseMapper<Financiador, FinanciadorRequest, FinanciadorResponse> mapper;
    @Mock
    private IValidarExistenciaService<Trabalho, Integer> validarExistenciaService;

    @Test
    void dadoUmFinanciadorTrabalhoExistenteQuandoFiltrarFinanciadoresEntaoDeveRetornarOsFinanciadoresEncontrados() {
        Integer idFinanciadorTrabalho = 1;
        List<Financiador> financiadores = FinanciadorMock.recuperarFinanciadoresPorTrabalho();
        List<FinanciadorResponse> financiadoresMapper = FinanciadorResponseMock.recuperarFinanciadoresPorTrabalho();

        when(financiadorRepository.filtrarFinanciadoresPorTrabalho(idFinanciadorTrabalho)).thenReturn(financiadores);
        doNothing().when(validarExistenciaService).validar(idFinanciadorTrabalho);
        when(mapper.toList(financiadores)).thenReturn(financiadoresMapper);

        List<FinanciadorResponse> result = financiadorPorTrabalhoService.filtrarFinanciadoresPorTrabalho(idFinanciadorTrabalho);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void dadoUmFinanciadorTrabalhoNaoEncontradoQuandoFiltrarFinanciadoresEntaoDeveLancarException() {
        Integer idFinanciadorTrabalhoNaoEncontrado = 0;
        doThrow(new EntidadeNaoEncontradaException(String.format("Entidade com ID %d não encontrada", idFinanciadorTrabalhoNaoEncontrado)))
                .when(validarExistenciaService)
                .validar(idFinanciadorTrabalhoNaoEncontrado);

        assertThrows(
                EntidadeNaoEncontradaException.class,
                () -> financiadorPorTrabalhoService.filtrarFinanciadoresPorTrabalho(idFinanciadorTrabalhoNaoEncontrado)
        );

        verify(validarExistenciaService).validar(idFinanciadorTrabalhoNaoEncontrado);
        verify(financiadorRepository, never()).filtrarFinanciadoresPorTrabalho(idFinanciadorTrabalhoNaoEncontrado);
        verify(mapper, never()).toList(any());
    }

}