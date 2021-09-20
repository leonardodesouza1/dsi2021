package br.univille.leonardosouzadsi2021.controller;

import br.univille.leonardosouzadsi2021.model.Funcionario;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/funcionario")
public class FuncionarioController extends GenericController<Funcionario> {

    @Autowired
    private FuncionarioServiceImpl service;

    public FuncionarioController(SharedRepository<Funcionario> repository) {
        super.setDependencies(repository);
    }

    @GetMapping("/form")
    public ModelAndView cadastro(@ModelAttribute Funcionario funcionario){
        List<Funcionario> funcionarios = service.getAll();
        return new ModelAndView("/funcionario/form","objetos", funcionarios);
    }

    @PostMapping(params="form")
    public ModelAndView save(Funcionario objeto){
        service.save(objeto);
        return new ModelAndView("redirect:/funcionario");
    }
}
