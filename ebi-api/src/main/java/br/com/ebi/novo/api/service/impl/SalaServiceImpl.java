package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.dto.request.SalaRequest;
import br.com.ebi.novo.api.dto.response.SalaResponse;
import br.com.ebi.novo.api.entity.Sala;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mapper.IPropertyCopier;
import br.com.ebi.novo.api.repository.ISalaRepository;
import br.com.ebi.novo.api.service.base.IBaseService;
import br.com.ebi.novo.api.exception.SalaNaoEncontradaException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaServiceImpl implements IBaseService<SalaRequest, SalaResponse> {

    private final ISalaRepository SalaRepository;
    private final IBaseMapper<Sala, SalaRequest, SalaResponse> mapper;
    private final IPropertyCopier<SalaRequest, Sala> propertyCopier;

    @Override
    public List<SalaResponse> listarTodos() {
        List<Sala> salas = SalaRepository.findAll();
        return mapper.toList(salas);
    }

    @Override
    public SalaResponse buscarPorId(Integer id) {
        Sala sala = SalaRepository.findById(id)
                .orElseThrow(() -> new SalaNaoEncontradaException(id));
        return mapper.toResponse(sala);
    }

    @Override
    public SalaResponse cadastrar(SalaRequest request) {
        Sala sala = mapper.toEntity(request);
        sala = SalaRepository.save(sala);
        return mapper.toResponse(sala);
    }

    @Override
    public SalaResponse editar(Integer id, SalaRequest request) {
        SalaResponse response = buscarPorId(id);
        Sala sala = mapper.responseToEntity(response);
        propertyCopier.copyProperties(request, sala);
        sala = SalaRepository.save(sala);
        return mapper.toResponse(sala);
    }

    @Override
    public void excluir(Integer id) {
        try {
            SalaRepository.deleteById(id);
            SalaRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new SalaNaoEncontradaException(id);
        }
    }
}
