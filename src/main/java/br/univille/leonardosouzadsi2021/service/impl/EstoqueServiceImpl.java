package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.MovimentacaoEstoque;
import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.repository.EstoqueRepository;
import br.univille.leonardosouzadsi2021.repository.ProdutoRepository;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EstoqueServiceImpl extends GenericService<MovimentacaoEstoque> {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public EstoqueServiceImpl(SharedRepository<MovimentacaoEstoque> repository) {
        super(repository);
    }

    public List<HashMap<String, Object>> getProdutosEstoque() {
        List<MovimentacaoEstoque> movimentacaoEstoques = estoqueRepository.findAll();
        List<HashMap<String, Object>> estoque = new ArrayList<>();
        List<Produto> produtos = produtoRepository.findAll();
        for (Iterator<Produto> it = produtos.iterator(); it.hasNext(); ) {
            Produto produto = it.next();
            List<MovimentacaoEstoque> movimentacaoProduto = movimentacaoEstoques.stream().
                    filter(p -> p.getProduto() == produto).collect(Collectors.toList());
            if(movimentacaoProduto.isEmpty()) {
                estoque.add(cadastraProdutoEstoque(produto,0,null));
            } else {
                int quantidade = calculaQuantidadeEstoque(movimentacaoProduto);
                estoque.add(cadastraProdutoEstoque(produto, quantidade, movimentacaoProduto.get(0).getData()));
            }
        }
        return estoque;
    }

    public int calculaQuantidadeEstoque(List<MovimentacaoEstoque> movimentacaoProduto) {
        int quantidade = 0;
        for (Iterator<MovimentacaoEstoque> it = movimentacaoProduto.iterator(); it.hasNext(); ) {
            MovimentacaoEstoque mov = it.next();
            switch (mov.getTipoMovimentacao()) {
                case SAIDA:
                    quantidade -= mov.getQuantidade();
                    break;
                case ENTRADA:
                    quantidade += mov.getQuantidade();
                    break;
            }
        }
        return Math.max(quantidade, 0);
    }

    public HashMap<String, Object> cadastraProdutoEstoque(Produto produto, int quantidade, Date data) {
        HashMap<String,Object> info = new HashMap<>();
        info.put("data",data);
        info.put("produto",produto);
        info.put("quantidade",quantidade);
        return info;
    }
}
