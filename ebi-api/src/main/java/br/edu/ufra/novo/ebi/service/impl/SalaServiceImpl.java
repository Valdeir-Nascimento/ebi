package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.SalaRequest;
import br.edu.ufra.novo.ebi.dto.response.SalaResponse;
import br.edu.ufra.novo.ebi.entity.Sala;
import br.edu.ufra.novo.ebi.exception.SalaNaoEncontradaException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import br.edu.ufra.novo.ebi.repository.ISalaRepository;
import br.edu.ufra.novo.ebi.service.base.IBaseService;
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
