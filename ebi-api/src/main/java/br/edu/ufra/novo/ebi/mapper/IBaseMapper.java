package br.edu.ufra.novo.ebi.mapper;

import java.util.List;

/**
 * Interface génerica para fazer conversão de classes
 * @param <T> O tipo de entidade mapeada com JPA
 * @param <R> O tipo de DTO usado para criar ou atualizar a entidade (Request).
 * @param <S> O tipo de DTO usado para representar a entidade em respostas (Response).
 */
public interface IBaseMapper<T, R, S> {

    T toEntity(R request, Class<T> entityClass);
    S toResponse(T entity, Class<S> responseClass);
    List<S> toList(List<T> entities, Class<S> responseClass);

}