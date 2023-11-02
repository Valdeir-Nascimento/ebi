package br.edu.ufra.novo.ebi.service.validator.impl;

import br.edu.ufra.novo.ebi.exception.EntidadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.service.validator.IValidarExistenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidarExistenciaServiceImpl<T, ID> implements IValidarExistenciaService<T, ID> {

    private final JpaRepository<T, ID> repository;

    @Override
    public void validar(ID entityId) {
        if (!repository.existsById(entityId)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + entityId + " não encontrada.");
        }
    }

}
