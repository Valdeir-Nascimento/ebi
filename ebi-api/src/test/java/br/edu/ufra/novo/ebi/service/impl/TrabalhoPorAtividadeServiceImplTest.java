package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.TrabalhoRequest;
import br.edu.ufra.novo.ebi.dto.response.TrabalhoResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.exception.EntidadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mock.entity.TrabalhoMock;
import br.edu.ufra.novo.ebi.mock.dto.response.TrabalhoResponeMock;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.ITrabalhoRepository;
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
class TrabalhoPorAtividadeServiceImplTest {

    @InjectMocks
    private TrabalhoPorAtividadeServiceImpl trabalhoPorAtividadeService;
    @Mock
    private ITrabalhoRepository trabalhoRepository;
    @Mock
    private IBaseMapper<Trabalho, TrabalhoRequest, TrabalhoResponse> mapper;
    @Mock
    private IValidarExistenciaService<Atividade, Integer> validarExistenciaService;

    @Test
    void dadoUmaAtividadeExistenteQuandoBuscarTrabalhosEntaoDeveRetornarTrabalhosPorAtividade() {
        Integer idAtividade = 1;
        List<Trabalho> trabalhos = TrabalhoMock.recuperarTrabalhosPorAtividade();
        when(trabalhoRepository.filtrarTrbalhosPorAtividade(idAtividade)).thenReturn(trabalhos);
        doNothing().when(validarExistenciaService).validar(idAtividade);
        when(mapper.toList(trabalhos)).thenReturn(TrabalhoResponeMock.recuperarTrabalhosPorAtividade());

        List<TrabalhoResponse> result = trabalhoPorAtividadeService.filtrarTrbalhosPorAtividade(idAtividade);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(trabalhos.size(), result.size());
        verify(validarExistenciaService).validar(idAtividade);
        verify(trabalhoRepository).filtrarTrbalhosPorAtividade(idAtividade);
        verify(mapper).toList(trabalhos);
    }

    @Test
    void dadoUmaAtividadeNaoExistenteQuandoFiltrarTrabalhosPorAtividadeEntaoDeveLancarException() {
        Integer idAtividadeNaoEncontrada = 0;
        doThrow(new EntidadeNaoEncontradaException(String.format("Entidade com ID %d", idAtividadeNaoEncontrada)))
                .when(validarExistenciaService)
                .validar(idAtividadeNaoEncontrada);

        assertThrows(EntidadeNaoEncontradaException.class, () -> trabalhoPorAtividadeService.filtrarTrbalhosPorAtividade(idAtividadeNaoEncontrada));

        verify(validarExistenciaService).validar(idAtividadeNaoEncontrada);
        verify(trabalhoRepository, never()).filtrarTrbalhosPorAtividade(idAtividadeNaoEncontrada);
        verify(mapper, never()).toList(any());
    }

}