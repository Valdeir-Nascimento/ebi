package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.FinanciadorRequest;
import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;
import br.edu.ufra.novo.ebi.entity.Financiador;
import br.edu.ufra.novo.ebi.entity.Trabalho;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IFinanciadorRepository;
import br.edu.ufra.novo.ebi.service.IFinanciadorPorTrabalhoService;
import br.edu.ufra.novo.ebi.service.base.validator.IValidarExistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanciadorPorTrabalhoServiceImpl implements IFinanciadorPorTrabalhoService {

    private final IFinanciadorRepository financiadorRepository;
    private final IBaseMapper<Financiador, FinanciadorRequest, FinanciadorResponse> mapper;
    private final IValidarExistenciaService<Trabalho, Integer> validarExistenciaService;

    @Override
    public List<FinanciadorResponse> filtrarFinanciadoresPorTrabalho(Integer idTrabalho) {
        validarExistenciaService.validar(idTrabalho);
        List<Financiador> financiadores = financiadorRepository.filtrarFinanciadoresPorTrabalho(idTrabalho);
        return mapper.toList(financiadores);
    }
}
