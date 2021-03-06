package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends GenericService<Produto> {
    public ProdutoServiceImpl(SharedRepository<Produto> repository) {
        super(repository);
    }
}
