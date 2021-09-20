package br.univille.leonardosouzadsi2021.service;

import java.util.List;

import br.univille.leonardosouzadsi2021.model.GenericEntity;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import org.springframework.stereotype.Service;

import br.univille.leonardosouzadsi2021.model.Produto;

@Service
public abstract class GenericService<T extends GenericEntity<T>> {

    private final SharedRepository<T> repository;

    public GenericService(SharedRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public void save(T objeto) {
        repository.save(objeto);
    }

    public void delete(T objeto) {
        repository.delete(objeto);
    }

}
