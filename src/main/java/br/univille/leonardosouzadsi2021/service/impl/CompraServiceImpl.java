package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.Compra;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl extends GenericService<Compra> {
    public CompraServiceImpl(SharedRepository<Compra> repository) {
        super(repository);
    }
}
