package br.univille.leonardosouzadsi2021.service.impl;

import br.univille.leonardosouzadsi2021.model.*;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CompraServiceImpl extends GenericService<Compra> {

    @Autowired
    EstoqueServiceImpl estoqueService;

    public CompraServiceImpl(SharedRepository<Compra> repository) {
        super(repository);
    }

    public float calculaValorTotalCompra(Compra compra) {
        List<ItemDaCompra> list = compra.getListaItens();
        float valorTotal = 0;
        for (Iterator<ItemDaCompra> it = list.iterator(); it.hasNext(); ) {
            ItemDaCompra element = it.next();
            int quantidade = element.getQuantidade();
            float valor = element.getProduto().getValor();
            valorTotal += quantidade * valor;
        }
        return valorTotal;
    }

    public void salvaCompra(Compra compra) {
        List<ItemDaCompra> itens = compra.getListaItens();
        for (Iterator<ItemDaCompra> it = itens.iterator(); it.hasNext(); ) {
            ItemDaCompra itemDaCompra = it.next();
            MovimentacaoEstoque movimentacaoEstoque =
                    new MovimentacaoEstoque(itemDaCompra.getProduto(), compra.getData(), itemDaCompra.getQuantidade(), TipoMovimentacao.ENTRADA);
            estoqueService.save(movimentacaoEstoque);
        }
        super.save(compra);
    }
}

