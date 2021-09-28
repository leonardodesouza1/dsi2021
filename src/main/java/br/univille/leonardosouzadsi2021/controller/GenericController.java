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

    public void setDependencies(SharedRepository<T> repository) {
        this.service = new GenericService<T>(repository) {};
    }

}