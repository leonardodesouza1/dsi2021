package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.MovimentacaoEstoque;
import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.repository.EstoqueRepository;
import br.univille.leonardosouzadsi2021.repository.ProdutoRepository;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueServiceImpl extends GenericService<MovimentacaoEstoque> {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public EstoqueServiceImpl(SharedRepository<MovimentacaoEstoque> repository) {
        super(repository);
    }

    public List<MovimentacaoEstoque> getProdutosEstoque() {
        List<MovimentacaoEstoque> movimentacaoEstoques = estoqueRepository.findAll();
        List<MovimentacaoEstoque> estoque = new ArrayList<>();
        List<Produto> produtos = produtoRepository.findAll();
        //todo separar por produtos, e fazer lógica de soma/subtração de entrada e saida.
        return estoque;
    }
}
