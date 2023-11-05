package br.edu.ufra.novo.ebi.mapper.impl;

import br.edu.ufra.novo.ebi.mapper.IPropertyCopier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class PropertyCopierImpl<S, T> implements IPropertyCopier<S, T> {

    @Override
    public void copyProperties(S source, T target) {
        // Verifica se os objetos de entrada não são nulos
        if (source == null || target == null) {
            throw new IllegalArgumentException("Objetos de entrada não podem ser nulos.");
        }
        // Obtém a classe do objeto "source"
        Class<?> requestClass = source.getClass();
        // Obtém a classe do objeto "target"
        Class<?> entityClass = target.getClass();
        // Obtém os campos (propriedades) da classe do objeto "source"
        Field[] requestFields = requestClass.getDeclaredFields();
        // Obtém os campos (propriedades) da classe do objeto "target"
        Field[] entityFields = entityClass.getDeclaredFields();
        // Percorre os campos do objeto "source" e copia as propriedades correspondentes para o "target"
        for (Field requestField : requestFields) {
            try {
                // Verifica se o campo também existe na classe do "target"
                Field entityField = entityClass.getDeclaredField(requestField.getName());
                // Torna o campo acessível para poder lê-lo e escrevê-lo
                requestField.setAccessible(true);
                entityField.setAccessible(true);
                // Copia o valor do campo do "source" para o "target"
                Object value = requestField.get(source);
                entityField.set(target, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
