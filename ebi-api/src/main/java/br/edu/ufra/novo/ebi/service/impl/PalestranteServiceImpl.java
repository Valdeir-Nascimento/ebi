package br.edu.ufra.novo.ebi.service.impl;

import br.edu.ufra.novo.ebi.entity.Autor;
import br.edu.ufra.novo.ebi.repository.IAutorRepository;
import br.edu.ufra.novo.ebi.service.IPalestranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PalestranteServiceImpl implements IPalestranteService {

    private final IAutorRepository autorRepository;

    @Override
    public List<Autor> obterPalestrantes() {
        return autorRepository.obterPalestrantes();
    }

}
