package br.univille.leonardosouzadsi2021.controller;

import br.univille.leonardosouzadsi2021.model.*;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.impl.CompraServiceImpl;
import br.univille.leonardosouzadsi2021.service.impl.EstoqueServiceImpl;
import br.univille.leonardosouzadsi2021.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/compra")
public class CompraController extends GenericController<Compra>{

    @Autowired
    CompraServiceImpl service;
    @Autowired
    ProdutoServiceImpl produtoService;
    @Autowired
    EstoqueServiceImpl estoqueService;

    public CompraController(SharedRepository<Compra> repository) {
        super.setDependencies(repository);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Compra compra) {
        List<Produto> listaProduto = this.produtoService.getAll();
        ItemDaCompra itemDaCompra = new ItemDaCompra();
        HashMap<String, Object> dados = new HashMap<>();

        dados.put("listaProduto", listaProduto);
        dados.put("compra", compra);
        dados.put("itemDaCompra", itemDaCompra);

        return new ModelAndView("compra/form",dados);
    }

    @PostMapping(params = {"insertcompra"})
    public ModelAndView insertcompra(ItemDaCompra itemDaCompra, Compra compra) {
        MovimentacaoEstoque movimentacaoEstoque =
                new MovimentacaoEstoque(itemDaCompra.getProduto(),compra.getData(), itemDaCompra.getQuantidade(), TipoMovimentacao.ENTRADA);
        estoqueService.save(movimentacaoEstoque);
        //todo adicionar na compra o itemDaCompra
        return new ModelAndView("redirect:/compra");
    }
}
