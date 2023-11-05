package br.edu.ufra.novo.ebi.mapper;

public interface IPropertyCopier<S, T> {

    void copyProperties(S source, T target);

}
