package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.exception.EntidadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mock.entity.AtividadeMock;
import br.edu.ufra.novo.ebi.mock.dto.response.AtividadeResponseMock;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IAtividadeRepository;
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

        doThrow(new EntidadeNaoEncontradaException(String.format("Entidade com ID %d não encontrada", idTipoAtividadeNaoExistente)))
                .when(validarExistenciaService)
                .validar(idTipoAtividadeNaoExistente);

        assertThrows(EntidadeNaoEncontradaException.class, () -> atividadePorTipoService.filtrarAtividadesPorTipo(idTipoAtividadeNaoExistente));

        verify(validarExistenciaService).validar(idTipoAtividadeNaoExistente);
        verify(atividadeRepository, never()).filtrarAtividadesPorTipo(idTipoAtividadeNaoExistente);
        verify(mapper, never()).toList(any());
    }
}