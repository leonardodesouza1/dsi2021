package br.univille.leonardosouzadsi2021.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PedidoDaVenda implements Serializable, GenericEntity<PedidoDaVenda>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Produto produto;

    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int valor) {
        this.quantidade = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void update(PedidoDaVenda objeto) {
        this.produto = objeto.getProduto();
        this.quantidade = objeto.getQuantidade();
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public PedidoDaVenda createNewInstance() {
        PedidoDaVenda newInstance = new PedidoDaVenda();
        newInstance.update(this);
        return newInstance;
    }
}
