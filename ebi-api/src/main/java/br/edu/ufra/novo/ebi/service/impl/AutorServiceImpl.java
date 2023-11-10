package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AutorRequest;
import br.edu.ufra.novo.ebi.dto.response.AutorResponse;
import br.edu.ufra.novo.ebi.entity.Autor;
import br.edu.ufra.novo.ebi.exception.AutorNaoEncontradoException;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import br.edu.ufra.novo.ebi.repository.IAutorRepository;
import br.edu.ufra.novo.ebi.service.base.IBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements IBaseService<AutorRequest, AutorResponse> {

    private final IAutorRepository AutorRepository;
    private final IBaseMapper<Autor, AutorRequest, AutorResponse> mapper;
    private final IPropertyCopier<AutorRequest, Autor> propertyCopier;

    @Override
    public List<AutorResponse> listarTodos() {
        List<Autor> Autors = AutorRepository.findAll();
        return mapper.toList(Autors);
    }

    @Override
    public AutorResponse buscarPorId(Integer id) {
        Autor Autor = AutorRepository.findById(id)
                .orElseThrow(() -> new AutorNaoEncontradoException(id));
        return mapper.toResponse(Autor);
    }

    @Override
    public AutorResponse cadastrar(AutorRequest request) {
        Autor Autor = mapper.toEntity(request);
        Autor = AutorRepository.save(Autor);
        return mapper.toResponse(Autor);
    }

    @Override
    public AutorResponse editar(Integer id, AutorRequest request) {
        AutorResponse response = buscarPorId(id);
        Autor Autor = mapper.responseToEntity(response);
        propertyCopier.copyProperties(request, Autor);
        Autor = AutorRepository.save(Autor);
        return mapper.toResponse(Autor);
    }

    @Override
    public void excluir(Integer id) {
        try {
            AutorRepository.deleteById(id);
            AutorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new AutorNaoEncontradoException(id);
        }
    }
}
