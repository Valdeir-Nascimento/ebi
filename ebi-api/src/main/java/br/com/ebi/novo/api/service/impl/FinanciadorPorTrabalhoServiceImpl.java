package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.response.FinanciadorResponse;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.repository.IFinanciadorRepository;
import br.com.ebi.novo.api.dto.request.FinanciadorRequest;
import br.com.ebi.novo.api.entity.Financiador;
import br.com.ebi.novo.api.entity.Trabalho;
import br.com.ebi.novo.api.service.IFinanciadorPorTrabalhoService;
import br.com.ebi.novo.api.service.base.validator.IValidarExistenciaService;
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
