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

    @GetMapping
    public ModelAndView index(){
        List<Compra> compras = service.getAll();
        return new ModelAndView("/compra/index","compras", compras);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Compra compra){
        List<Produto> listaProduto = produtoService.getAll();

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("compra", compra);
        dados.put("listaProduto", listaProduto);
        dados.put("novopedcompra", new ItemDaCompra());
        dados.put("valortotal", service.calculaValorTotalCompra(compra));
        return new ModelAndView("compra/form",dados);
    }

    @PostMapping()
    public ModelAndView save(Compra compra){
        service.salvaCompra(compra);
        return new ModelAndView("redirect:/compra");
    }

    @PostMapping(params= {"insertprod"})
    public ModelAndView insertproc(Compra compra, ItemDaCompra novopedcompra) {
        List<Produto> listaProduto = produtoService.getAll();
        compra.getListaItens().add(novopedcompra);

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("compra", compra);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalCompra(compra));
        dados.put("novopedcompra", new ItemDaCompra());

        return new ModelAndView("compra/form",dados);
    }

    @PostMapping(params= {"removeprod"})
    public ModelAndView removeproc(@RequestParam(name = "removeprod") int index, Compra compra, ItemDaCompra novopedcompra) {
        List<Produto> listaProduto = produtoService.getAll();
        compra.getListaItens().remove(novopedcompra);

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("compra", compra);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalCompra(compra));
        dados.put("novopedcompra", new ItemDaCompra());

        return new ModelAndView("compra/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Compra compra){
        List<Produto> listaProduto = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("compra", compra);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalCompra(compra));
        dados.put("novopedcompra", new ItemDaCompra());
        return new ModelAndView("compra/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Compra compra){
        service.delete(compra);
        return new ModelAndView("redirect:/compra");
    }
}
