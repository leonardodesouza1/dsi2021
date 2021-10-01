package br.univille.leonardosouzadsi2021.controller;

import br.univille.leonardosouzadsi2021.model.*;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.impl.ProdutoServiceImpl;
import br.univille.leonardosouzadsi2021.service.impl.VendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/venda")
public class VendaController extends GenericController<Venda> {

    @Autowired
    VendaServiceImpl service;
    @Autowired
    ProdutoServiceImpl produtoService;


    public VendaController(SharedRepository<Venda> repository) {
        super.setDependencies(repository);
    }

    @GetMapping
    public ModelAndView index(){
        List<Venda> vendas = service.getAll();
        return new ModelAndView("/venda/index","vendas", vendas);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Venda venda){
        List<Produto> listaProduto = produtoService.getAll();

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("venda", venda);
        dados.put("listaProduto", listaProduto);
        dados.put("novopedvenda", new PedidoDaVenda());
        dados.put("valortotal", service.calculaValorTotalVenda(venda));
        return new ModelAndView("venda/form",dados);
    }

    @PostMapping()
    public ModelAndView save(Venda venda){
        service.save(venda);
        return new ModelAndView("redirect:/venda");
    }

    @PostMapping(params= {"insertprod"})
    public ModelAndView insertproc(Venda venda, PedidoDaVenda novopedvenda) {
        List<Produto> listaProduto = produtoService.getAll();
        venda.getPedidoDaVenda().add(novopedvenda);

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("venda", venda);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalVenda(venda));
        dados.put("novopedvenda", new PedidoDaVenda());

        return new ModelAndView("venda/form",dados);
    }

    @PostMapping(params= {"removeprod"})
    public ModelAndView removeproc(@RequestParam(name = "removeprod") int index, Venda venda, PedidoDaVenda novopedvenda) {
        List<Produto> listaProduto = produtoService.getAll();
        venda.getPedidoDaVenda().remove(novopedvenda);

        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("venda", venda);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalVenda(venda));
        dados.put("novopedvenda", new PedidoDaVenda());

        return new ModelAndView("venda/form",dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Venda venda){
        List<Produto> listaProduto = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("venda", venda);
        dados.put("listaProduto", listaProduto);
        dados.put("valortotal", service.calculaValorTotalVenda(venda));
        dados.put("novopedvenda", new PedidoDaVenda());
        return new ModelAndView("venda/form",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Venda venda){
        service.delete(venda);
        return new ModelAndView("redirect:/venda");
    }

}
