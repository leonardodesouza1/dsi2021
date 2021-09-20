package br.univille.leonardosouzadsi2021.controller;

import br.univille.leonardosouzadsi2021.model.GenericEntity;
import br.univille.leonardosouzadsi2021.model.Produto;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.GenericService;
import br.univille.leonardosouzadsi2021.service.impl.EstoqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>> {

    private GenericService<T> service;
    private final String map = this.getClass().getAnnotation(RequestMapping.class).value()[0];

    public void setDependencies(SharedRepository<T> repository) {
        this.service = new GenericService<T>(repository) {};
    }

    @GetMapping
    public ModelAndView index(){
        List<T> objetos = service.getAll();
        return new ModelAndView(this.map + "/index","objetos", objetos);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute T objeto){
        List<T> objetos = service.getAll();
        return new ModelAndView(this.map + "/form","objetos", objetos);
    }


    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") T objeto){
        return new ModelAndView(this.map + "/form", objeto.getClass().getSimpleName().toLowerCase() , objeto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") T obj){
        service.delete(obj);
        return new ModelAndView("redirect:" + this.map);
    }
}