package br.edu.ufra.novo.ebi.service.validator;

public interface IValidarExistenciaService<T, ID> {

    void validar(ID entityId);

}
