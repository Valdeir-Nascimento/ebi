package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.TipoAtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.TipoAtividadeResponse;
import br.edu.ufra.novo.ebi.entity.TipoAtividade;
import br.edu.ufra.novo.ebi.exception.TipoAtividadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import br.edu.ufra.novo.ebi.mock.dto.request.TipoAtividadeRequestMock;
import br.edu.ufra.novo.ebi.mock.dto.response.TipoAtividadeResponseMock;
import br.edu.ufra.novo.ebi.mock.entity.TipoAtividadeMock;
import br.edu.ufra.novo.ebi.repository.ITipoAtividadeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TipoAtividadeServiceImplTest {

    @InjectMocks
    private TipoAtividadeServiceImpl tipoAtividadeService;
    @Mock
    private ITipoAtividadeRepository tipoAtividadeRepository;
    @Mock
    private IBaseMapper<TipoAtividade, TipoAtividadeRequest, TipoAtividadeResponse> mapper;
    @Mock
    private IPropertyCopier<TipoAtividadeRequest, TipoAtividade> propertyCopier;

    @Test
    void dadoUmaListaDeTipoAtividadesValidaQuandoListarTodosEntaoDeveRetonarTodosOsTiposAtividades() {
        List<TipoAtividade> atividades = TipoAtividadeMock.listarTodos();
        List<TipoAtividadeResponse> response = TipoAtividadeResponseMock.listarTodos();

        when(tipoAtividadeRepository.findAll()).thenReturn(atividades);
        when(mapper.toList(atividades)).thenReturn(response);
        List<TipoAtividadeResponse> result = tipoAtividadeService.listarTodos();

        assertEquals(response, result);
        verify(tipoAtividadeRepository, times(1)).findAll();
        verify(mapper, times(1)).toList(atividades);
    }

    @Test
    void dadoUmTipoAtividadeExistenteQuandoBuscarPorIdEntaoDeveRetornarTipoAtividadeEncontrada() {
        Integer idTipoAtividade = 1;
        TipoAtividade tipoAtividade = TipoAtividadeMock.getTipoAtividade();
        TipoAtividadeResponse response = TipoAtividadeResponseMock.getTipoAtividade();

        when(tipoAtividadeRepository.findById(idTipoAtividade)).thenReturn(Optional.of(tipoAtividade));
        when(mapper.toResponse(tipoAtividade)).thenReturn(response);

        TipoAtividadeResponse result = tipoAtividadeService.buscarPorId(idTipoAtividade);

        assertEquals(response, result);
        verify(tipoAtividadeRepository, times(1)).findById(idTipoAtividade);
        verify(mapper, times(1)).toResponse(tipoAtividade);
    }

    @Test
    void dadoUmTipoAtividadeNaoExistenteQuandoBuscarPorIdEntaoDeveLancarException() {
        Integer idTipoAtividadeNaoExistente = 0;
        when(tipoAtividadeRepository.findById(idTipoAtividadeNaoExistente)).thenReturn(Optional.empty());

        assertThrows(TipoAtividadeNaoEncontradaException.class, () -> tipoAtividadeService.buscarPorId(idTipoAtividadeNaoExistente));

        verify(tipoAtividadeRepository, times(1)).findById(idTipoAtividadeNaoExistente);
        verify(mapper, never()).toResponse(any());
    }

    @Test
    void dadoUmTipoAtividadeValidoQuandoCadastrarEntaoDeveRetornarNovoRecursoCriado() {
        TipoAtividade tipoAtividade = TipoAtividadeMock.getTipoAtividade();
        TipoAtividadeRequest request = TipoAtividadeRequestMock.getTipoAtividade();
        TipoAtividadeResponse response = TipoAtividadeResponseMock.getTipoAtividade();

        when(mapper.toEntity(request)).thenReturn(tipoAtividade);
        when(tipoAtividadeRepository.save(tipoAtividade)).thenReturn(tipoAtividade);
        when(mapper.toResponse(tipoAtividade)).thenReturn(response);

        TipoAtividadeResponse result = tipoAtividadeService.cadastrar(request);

        assertEquals(response, result);
        verify(mapper, times(1)).toEntity(request);
        verify(tipoAtividadeRepository, times(1)).save(tipoAtividade);
        verify(mapper, times(1)).toResponse(tipoAtividade);
    }

    @Test
    void dadoUmTipoAtividadeExistenteQuandoEditarEntaoDeveRetornarTipoAtividade() {
        Integer idTipoAtividade = 1;
        TipoAtividade tipoAtividade = TipoAtividadeMock.getTipoAtividade();
        TipoAtividadeRequest request = TipoAtividadeRequestMock.getTipoAtividade();
        TipoAtividadeResponse response = TipoAtividadeResponseMock.getTipoAtividade();

        when(tipoAtividadeRepository.findById(idTipoAtividade)).thenReturn(Optional.of(tipoAtividade));
        when(tipoAtividadeService.buscarPorId(idTipoAtividade)).thenReturn(response);
        when(mapper.responseToEntity(response)).thenReturn(tipoAtividade);
        doNothing().when(propertyCopier).copyProperties(request, tipoAtividade);
        when(tipoAtividadeRepository.save(tipoAtividade)).thenReturn(tipoAtividade);
        when(mapper.toResponse(tipoAtividade)).thenReturn(response);

        TipoAtividadeResponse result = tipoAtividadeService.editar(idTipoAtividade, request);

        assertEquals(response, result);
        verify(tipoAtividadeRepository, times(2)).findById(idTipoAtividade);
        verify(mapper, times(1)).responseToEntity(response);
        verify(propertyCopier, times(1)).copyProperties(request, tipoAtividade);
        verify(tipoAtividadeRepository, times(1)).save(tipoAtividade);
        verify(mapper, times(2)).toResponse(tipoAtividade);
    }

    @Test
    void dadoUmTipoAtividadeNaoExistenteQuandoEditarEntaoDeveLancarException() {
        Integer idTipoAtividadeNaoExistente = 0;
        TipoAtividadeRequest request = TipoAtividadeRequestMock.getTipoAtividade();

        when(tipoAtividadeRepository.findById(idTipoAtividadeNaoExistente)).thenReturn(Optional.empty());
        assertThrows(TipoAtividadeNaoEncontradaException.class, () -> tipoAtividadeService.editar(idTipoAtividadeNaoExistente, request));

        verify(tipoAtividadeRepository, times(1)).findById(idTipoAtividadeNaoExistente);
        verify(mapper, never()).responseToEntity(any());
        verify(propertyCopier, never()).copyProperties(any(), any());
        verify(tipoAtividadeRepository, never()).save(any());
        verify(mapper, never()).toResponse(any());
    }

    @Test
    void dadoUmTipoAtividadeExistenteComPropriedadeDiferenteDaEntidadeQuandoEditarDeveLancarException() {
        Integer idTipoAtividade = 1;
        TipoAtividade tipoAtividade = TipoAtividadeMock.getTipoAtividade();
        TipoAtividadeRequest request = TipoAtividadeRequestMock.getTipoAtividade();
        TipoAtividadeResponse response = TipoAtividadeResponseMock.getTipoAtividade();

        when(tipoAtividadeRepository.findById(idTipoAtividade)).thenReturn(Optional.of(tipoAtividade));
        when(tipoAtividadeService.buscarPorId(idTipoAtividade)).thenReturn(response);
        when(mapper.responseToEntity(response)).thenReturn(tipoAtividade);
        doThrow(new RuntimeException("CopyProperties exception")).when(propertyCopier).copyProperties(request, tipoAtividade);

        assertThrows(RuntimeException.class, () -> tipoAtividadeService.editar(idTipoAtividade, request));

        verify(tipoAtividadeRepository, times(2)).findById(idTipoAtividade);
        verify(mapper, times(1)).responseToEntity(response);
        verify(propertyCopier, times(1)).copyProperties(request, tipoAtividade);
        verify(tipoAtividadeRepository, never()).save(tipoAtividade);
    }

    @Test
    void dadoUmtipoAtividadeExistenteQuandoExcluirPorIdEntaoDeveRemoverRegistro() {
        Integer idTipoAtividade = 1;
        doNothing().when(tipoAtividadeRepository).deleteById(idTipoAtividade);
        doNothing().when(tipoAtividadeRepository).flush();

        tipoAtividadeService.excluir(idTipoAtividade);

        verify(tipoAtividadeRepository, times(1)).deleteById(idTipoAtividade);
        verify(tipoAtividadeRepository, times(1)).flush();
    }

    @Test
    void dadoUmTipoAtividadeNaoExistenteQuandoExcluirPorIdEntaoDeveLancarException() {
        Integer idTipoAtividadeNaoExistente = 0;
        doThrow(new EmptyResultDataAccessException(1)).when(tipoAtividadeRepository).deleteById(idTipoAtividadeNaoExistente);

        assertThrows(TipoAtividadeNaoEncontradaException.class, () -> tipoAtividadeService.excluir(idTipoAtividadeNaoExistente));

        verify(tipoAtividadeRepository, times(1)).deleteById(idTipoAtividadeNaoExistente);
        verify(tipoAtividadeRepository, never()).flush();
    }

}