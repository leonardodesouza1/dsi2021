package br.univille.leonardosouzadsi2021.controller;

import java.util.List;

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
    @PostMapping(params="form")
    public ModelAndView save(Produto objeto){
        service.save(objeto);
        return new ModelAndView("redirect:/produto");
    }
}
