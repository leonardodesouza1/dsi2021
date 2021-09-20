package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.Funcionario;
import br.univille.leonardosouzadsi2021.model.GenericEntity;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl extends GenericService<Funcionario> {
    public FuncionarioServiceImpl(SharedRepository<Funcionario> repository) {
        super(repository);
    }
}
