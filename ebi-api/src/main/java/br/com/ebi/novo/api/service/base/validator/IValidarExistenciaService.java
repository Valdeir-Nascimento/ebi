package br.com.ebi.novo.api.service.base.validator;

public interface IValidarExistenciaService<T, ID> {

    void validar(ID entityId);

}
