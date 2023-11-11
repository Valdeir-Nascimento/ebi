package br.com.ebi.novo.api.mapper;

public interface IPropertyCopier<S, T> {

    void copyProperties(S source, T target);

}
