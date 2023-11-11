package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.exception.AutorNaoEncontradoException;
import br.com.ebi.novo.api.dto.request.AutorRequest;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import br.com.ebi.novo.api.entity.Autor;
import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.mapper.IPropertyCopier;
import br.com.ebi.novo.api.repository.IAutorRepository;
import br.com.ebi.novo.api.service.base.IBaseService;
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
