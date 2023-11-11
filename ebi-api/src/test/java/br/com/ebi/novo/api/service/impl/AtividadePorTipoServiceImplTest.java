package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.request.AtividadeRequest;
import br.com.ebi.novo.api.dto.response.AtividadeResponse;
import br.com.ebi.novo.api.exception.EntidadeNaoEncontradaException;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mock.dto.response.AtividadeResponseMock;
import br.com.ebi.novo.api.mock.entity.AtividadeMock;
import br.com.ebi.novo.api.service.base.validator.IValidarExistenciaService;
import br.com.ebi.novo.api.entity.Atividade;
import br.com.ebi.novo.api.repository.IAtividadeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AtividadePorTipoServiceImplTest {

    @InjectMocks
    private AtividadePorTipoServiceImpl atividadePorTipoService;
    @Mock
    private IAtividadeRepository atividadeRepository;
    @Mock
    private IValidarExistenciaService<Atividade, Integer> validarExistenciaService;
    @Mock
    private IBaseMapper<Atividade, AtividadeRequest, AtividadeResponse> mapper;

    @Test
    void dadoUmTipoAtividadeExistenteQuandoFiltrarEntaoDeveRetornarListaDeAtividades() {
        Integer idTipoAtividadeExistente = 1;
        List<Atividade> atividades = AtividadeMock.recuperarAtividadesPorTipo();
        List<AtividadeResponse> atividadesMapper = AtividadeResponseMock.recuperarAtividadesPorTipo();

        when(atividadeRepository.filtrarAtividadesPorTipo(idTipoAtividadeExistente)).thenReturn(atividades);
        doNothing().when(validarExistenciaService).validar(idTipoAtividadeExistente);
        when(mapper.toList(atividades)).thenReturn(atividadesMapper);

        List<AtividadeResponse> resposta = atividadePorTipoService.filtrarAtividadesPorTipo(idTipoAtividadeExistente);

        assertNotNull(resposta);
        assertFalse(resposta.isEmpty());
    }

    @Test
    void dadoUmTipoAtividadeNaoExistenteQuandoFiltrarEntaoDeveLancarException() {
        Integer idTipoAtividadeNaoExistente = 0;

        Mockito.doThrow(new EntidadeNaoEncontradaException(String.format("Entidade com ID %d não encontrada", idTipoAtividadeNaoExistente)))
                .when(validarExistenciaService)
                .validar(idTipoAtividadeNaoExistente);

        assertThrows(EntidadeNaoEncontradaException.class, () -> atividadePorTipoService.filtrarAtividadesPorTipo(idTipoAtividadeNaoExistente));

        verify(validarExistenciaService).validar(idTipoAtividadeNaoExistente);
        verify(atividadeRepository, never()).filtrarAtividadesPorTipo(idTipoAtividadeNaoExistente);
        verify(mapper, never()).toList(any());
    }
}