package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AutorRequest;
import br.edu.ufra.novo.ebi.dto.response.AutorResponse;
import br.edu.ufra.novo.ebi.entity.Autor;
import br.edu.ufra.novo.ebi.mock.entity.AutorMock;
import br.edu.ufra.novo.ebi.mock.dto.response.AutorResponseMock;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IAutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PalestranteServiceImplTest {

    @InjectMocks
    private PalestranteServiceImpl palestranteService;
    @Mock
    private IAutorRepository autorRepository;
    @Mock
    private IBaseMapper<Autor, AutorRequest, AutorResponse> mapper;

    @Test
    void dadoUmaListaDeAutoresQuandoFiltrarPalestrantesEntaoDeveRetornarOsAutoresPalestrantes() {
        List<Autor> palestrantes = AutorMock.filtrarPalestrantes();
        when(autorRepository.obterPalestrantes()).thenReturn(palestrantes);
        when(mapper.toList(palestrantes)).thenReturn(AutorResponseMock.filtrarPalestrantes());

        List<AutorResponse> result = palestranteService.filtrarPalestrantes();

        assertNotNull(result);
        assertEquals(palestrantes.size(), result.size());
        verify(autorRepository).obterPalestrantes();
        verify(mapper).toList(palestrantes);
    }

}