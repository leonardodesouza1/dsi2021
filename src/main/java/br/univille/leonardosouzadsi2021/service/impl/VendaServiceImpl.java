package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.*;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class VendaServiceImpl extends GenericService<Venda> {
    public VendaServiceImpl(SharedRepository<Venda> repository) {
        super(repository);
    }

    @Autowired
    EstoqueServiceImpl estoqueService;

    public float calculaValorTotalVenda(Venda venda){
        List<PedidoDaVenda> list = venda.getPedidoDaVenda();
        float valorTotal = 0;
        for(Iterator<PedidoDaVenda> it = list.iterator(); it.hasNext();){
            PedidoDaVenda element = it.next();
            int quantidade = element.getQuantidade();
            float valor = element.getProduto().getValor();
            valorTotal += quantidade * valor;
        }
        return valorTotal;
    }

    public void salvaVenda(Venda venda) {
        List<PedidoDaVenda> itens = venda.getPedidoDaVenda();
        for (Iterator<PedidoDaVenda> it = itens.iterator(); it.hasNext(); ) {
            PedidoDaVenda pedidoDaVenda = it.next();
            MovimentacaoEstoque movimentacaoEstoque =
                    new MovimentacaoEstoque(pedidoDaVenda.getProduto(), venda.getData(), pedidoDaVenda.getQuantidade(), TipoMovimentacao.SAIDA);
            estoqueService.save(movimentacaoEstoque);
        }
        super.save(venda);
    }
}
