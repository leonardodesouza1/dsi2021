package br.univille.leonardosouzadsi2021.model;

public interface GenericEntity<T> {
    // update current instance with provided data
    void update(T objeto);

    Long getId();

    // based on current data create new instance with new id
    T createNewInstance();

}