package br.univille.leonardosouzadsi2021.repository;

import br.univille.leonardosouzadsi2021.model.Produto;

import java.util.Optional;


public interface ProdutoRepository extends SharedRepository<Produto> {

    @Override
    Optional<Produto> findById(Long aLong);
}
