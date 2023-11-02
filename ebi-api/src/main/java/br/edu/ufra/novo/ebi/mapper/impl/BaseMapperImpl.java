package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.mapper.IBaseMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BaseMapperImpl<T, R, S> implements IBaseMapper<T, R, S> {

    @Override
    public T toEntity(R request, Class<T> entityClass) {
        try {
            T entity = entityClass.getDeclaredConstructor().newInstance();
            copyFields(request, entity);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar instância da entidade: " + e.getMessage());
        }
    }

    @Override
    public S toResponse(T entity, Class<S> responseClass) {
        try {
            S response = responseClass.getDeclaredConstructor().newInstance();
            copyFields(entity, response);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar instância da classe de resposta: " + e.getMessage());
        }
    }

    @Override
    public List<S> toList(List<T> entities, Class<S> responseClass) {
        return entities.stream()
                .map(entity -> toResponse(entity, responseClass))
                .collect(Collectors.toList());
    }

    private void copyFields(Object source, Object target) throws IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            for (Field targetField : targetFields) {
                if (sourceField.getName().equals(targetField.getName())) {
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    Object value = sourceField.get(source);
                    targetField.set(target, value);
                }
            }
        }
    }
}
