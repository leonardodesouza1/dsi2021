package br.univille.leonardosouzadsi2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index(){
        List<Produto> produtos = service.getAll();
        return new ModelAndView("produto/index","produtos", produtos);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Produto produto){
        List<Produto> produtos = service.getAll();
        return new ModelAndView("produto/form","produtos", produtos);
    }

    @PostMapping(params="form")
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping("alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto){
        return new ModelAndView("/produto/form", "produto", produto);
    }
}
