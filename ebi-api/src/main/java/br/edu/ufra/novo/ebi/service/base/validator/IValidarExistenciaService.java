package br.edu.ufra.novo.ebi.service.base.validator;

public interface IValidarExistenciaService<T, ID> {

    void validar(ID entityId);

}
