package br.edu.ufra.novo.ebi.service.base.validator.impl;

import br.edu.ufra.novo.ebi.exception.EntidadeNaoEncontradaException;
import br.edu.ufra.novo.ebi.service.base.validator.IValidarExistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidarExistenciaServiceImpl<T, ID> implements IValidarExistenciaService<T, ID> {

    private final JpaRepository<T, ID> repository;

    @Autowired
    public ValidarExistenciaServiceImpl(@Qualifier("IAtividadeRepository") JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public void validar(ID entityId) {
        if (!repository.existsById(entityId)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + entityId + " não encontrada.");
        }
    }

}
