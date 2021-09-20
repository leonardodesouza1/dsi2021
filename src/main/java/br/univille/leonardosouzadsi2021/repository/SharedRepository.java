package br.univille.leonardosouzadsi2021.repository;

import java.util.List;

import br.univille.leonardosouzadsi2021.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import br.univille.leonardosouzadsi2021.model.Produto;

@NoRepositoryBean
public interface SharedRepository<T extends GenericEntity<T>> extends JpaRepository<T, Long> {
}
