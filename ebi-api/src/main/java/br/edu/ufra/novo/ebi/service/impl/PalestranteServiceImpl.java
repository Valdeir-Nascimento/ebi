package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.dto.request.AutorRequest;
import br.edu.ufra.novo.ebi.dto.response.AutorResponse;
import br.edu.ufra.novo.ebi.entity.Autor;
import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import br.edu.ufra.novo.ebi.repository.IAutorRepository;
import br.edu.ufra.novo.ebi.service.IPalestranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PalestranteServiceImpl implements IPalestranteService {

    private final IAutorRepository autorRepository;
    private final IBaseMapper<Autor, AutorRequest, AutorResponse> mapper;

    @Override
    public List<AutorResponse> obterPalestrantes() {
        List<Autor> palestrantes = autorRepository.obterPalestrantes();
        return mapper.toList(palestrantes);
    }

}
