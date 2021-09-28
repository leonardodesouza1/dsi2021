package br.univille.leonardosouzadsi2021.controller;

import java.util.List;

import br.univille.leonardosouzadsi2021.model.Compra;
import br.univille.leonardosouzadsi2021.model.Funcionario;
import br.univille.leonardosouzadsi2021.repository.ProdutoRepository;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.service.GenericService;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController extends GenericController<Produto>{

    @Autowired
    ProdutoServiceImpl service;

    public ProdutoController(SharedRepository<Produto> repository) {
        super.setDependencies(repository);
    }

    @GetMapping
    public ModelAndView index(){
        List<Produto> objetos = service.getAll();
        return new ModelAndView("/produto/index","objetos", objetos);
    }

    @PostMapping(params="form")
    public ModelAndView save(Produto objeto){
        service.save(objeto);
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Produto objeto){
        List<Produto> objetos = service.getAll();
        return new ModelAndView("/produto/form","objetos", objetos);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto objeto){
        return new ModelAndView("/produto/form", "produto" , objeto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Produto obj){
        service.delete(obj);
        return new ModelAndView("redirect:produto");
    }
}
