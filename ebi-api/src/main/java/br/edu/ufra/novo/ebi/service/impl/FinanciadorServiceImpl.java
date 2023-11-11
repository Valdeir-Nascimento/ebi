package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.FinanciadorRequest;
import br.edu.ufra.novo.ebi.dto.response.FinanciadorResponse;
import br.edu.ufra.novo.ebi.entity.Financiador;
import br.edu.ufra.novo.ebi.exception.FinanciadorNaoEncontradoException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import br.edu.ufra.novo.ebi.repository.IFinanciadorRepository;
import br.edu.ufra.novo.ebi.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanciadorServiceImpl implements IBaseService<FinanciadorRequest, FinanciadorResponse> {

    private final IFinanciadorRepository financiadorRepository;
    private final IBaseMapper<Financiador, FinanciadorRequest, FinanciadorResponse> financiadorMapper;
    private final IPropertyCopier<FinanciadorRequest, Financiador> propertyCopier;

    @Override
    public List<FinanciadorResponse> listarTodos() {
        List<Financiador> financiadores = financiadorRepository.findAll();
        return financiadorMapper.toList(financiadores);
    }

    @Override
    public FinanciadorResponse buscarPorId(Integer id) {
        Financiador financiador = financiadorRepository.findById(id)
                .orElseThrow(() -> new FinanciadorNaoEncontradoException(id));
        return financiadorMapper.toResponse(financiador);
    }

    @Override
    public FinanciadorResponse cadastrar(FinanciadorRequest request) {
        Financiador financiador = financiadorMapper.toEntity(request);
        financiador = financiadorRepository.save(financiador);
        return financiadorMapper.toResponse(financiador);
    }

    @Override
    public FinanciadorResponse editar(Integer id, FinanciadorRequest request) {
        FinanciadorResponse response = buscarPorId(id);
        Financiador financiador = financiadorMapper.responseToEntity(response);
        propertyCopier.copyProperties(request, financiador);
        financiador = financiadorRepository.save(financiador);
        return financiadorMapper.toResponse(financiador);
    }

    @Override
    public void excluir(Integer id) {
        try {
            financiadorRepository.deleteById(id);
            financiadorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new FinanciadorNaoEncontradoException(id);
        }
    }
}
