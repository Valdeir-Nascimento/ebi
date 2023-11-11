package br.com.ebi.novo.api.service.impl;

import br.com.ebi.novo.api.mapper.IBaseMapper;
import br.com.ebi.novo.api.service.IPalestranteService;
import br.com.ebi.novo.api.dto.request.AutorRequest;
import br.com.ebi.novo.api.dto.response.AutorResponse;
import br.com.ebi.novo.api.entity.Autor;
import br.com.ebi.novo.api.repository.IAutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PalestranteServiceImpl implements IPalestranteService {

    private final IAutorRepository autorRepository;
    private final IBaseMapper<Autor, AutorRequest, AutorResponse> mapper;

    @Override
    public List<AutorResponse> filtrarPalestrantes() {
        List<Autor> palestrantes = autorRepository.obterPalestrantes();
        return mapper.toList(palestrantes);
    }

}
