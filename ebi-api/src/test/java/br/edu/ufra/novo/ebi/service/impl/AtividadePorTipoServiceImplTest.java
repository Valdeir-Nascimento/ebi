package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AtividadeRequest;
import br.edu.ufra.novo.ebi.dto.response.AtividadeResponse;
import br.edu.ufra.novo.ebi.entity.Atividade;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IAtividadeRepository;
import br.edu.ufra.novo.ebi.service.base.validator.IValidarExistenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void dadoUmTipoAtividadeExistenteQuandoFiltrarEntaoDeveRetornarListaDeAtividades() {
        Integer idTipoAtividade = 1;
        List<AtividadeResponse> atividades = atividadePorTipoService.filtrarAtividadesPorTipo(idTipoAtividade);
        assertNotNull(atividades);
    }


}