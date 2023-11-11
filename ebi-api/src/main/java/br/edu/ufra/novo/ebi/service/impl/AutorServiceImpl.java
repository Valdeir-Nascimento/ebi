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

    private final IAutorRepository autorRepository;
    private final IBaseMapper<Autor, AutorRequest, AutorResponse> mapper;
    private final IPropertyCopier<AutorRequest, Autor> propertyCopier;

    @Override
    public List<AutorResponse> listarTodos() {
        List<Autor> autores = autorRepository.findAll();
        return mapper.toList(autores);
    }

    @Override
    public AutorResponse buscarPorId(Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new AutorNaoEncontradoException(id));
        return mapper.toResponse(autor);
    }

    @Override
    public AutorResponse cadastrar(AutorRequest request) {
        Autor autor = mapper.toEntity(request);
        autor = autorRepository.save(autor);
        return mapper.toResponse(autor);
    }

    @Override
    public AutorResponse editar(Integer id, AutorRequest request) {
        AutorResponse response = buscarPorId(id);
        Autor autor = mapper.responseToEntity(response);
        propertyCopier.copyProperties(request, autor);
        autor = autorRepository.save(autor);
        return mapper.toResponse(autor);
    }

    @Override
    public void excluir(Integer id) {
        try {
            autorRepository.deleteById(id);
            autorRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new AutorNaoEncontradoException(id);
        }
    }
}
