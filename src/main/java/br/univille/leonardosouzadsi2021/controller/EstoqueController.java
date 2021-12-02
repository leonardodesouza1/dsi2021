package br.univille.leonardosouzadsi2021.controller;

import br.univille.leonardosouzadsi2021.model.MovimentacaoEstoque;
import br.univille.leonardosouzadsi2021.repository.SharedRepository;
import br.univille.leonardosouzadsi2021.service.impl.EstoqueServiceImpl;
import br.univille.leonardosouzadsi2021.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/estoque")
public class EstoqueController extends GenericController<MovimentacaoEstoque>{


    @Autowired
    private EstoqueServiceImpl service;
    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    public EstoqueController(SharedRepository<MovimentacaoEstoque> repository) {
        super.setDependencies(repository);
    }

    @GetMapping
    public ModelAndView index(){
        List<HashMap<String, Object>> objetos = service.getProdutosEstoque();
        return new ModelAndView("/estoque/index","objetos", objetos);
    }

}
