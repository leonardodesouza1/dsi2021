package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.MovimentacaoEstoque;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl extends GenericService<MovimentacaoEstoque> {
    public EstoqueServiceImpl(SharedRepository<MovimentacaoEstoque> repository) {
        super(repository);
    }
}
