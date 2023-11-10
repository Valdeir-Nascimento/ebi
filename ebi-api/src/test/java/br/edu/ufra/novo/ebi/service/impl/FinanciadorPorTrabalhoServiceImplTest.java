package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.FinanciadorRequest;
import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;
import br.edu.ufra.novo.ebi.entity.Financiador;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.exception.EntidadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mock.entity.FinanciadorMock;
import br.edu.ufra.novo.ebi.mock.dto.response.FinanciadorResponseMock;
import br.edu.ufra.novo.ebi.repository.IFinanciadorRepository;
import br.edu.ufra.novo.ebi.service.base.validator.IValidarExistenciaService;
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