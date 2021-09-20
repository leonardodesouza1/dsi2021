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

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<Produto> listaProdutosVenda = new ArrayList<Produto>();

    private float valor;

    public List<Produto> getListaProdutosVenda() {
        return listaProdutosVenda;
    }

    public void setListaProdutosVenda(List<Produto> listaProdutosVenda) {
        this.listaProdutosVenda = listaProdutosVenda;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void update(PedidoDaVenda objeto) {
        this.listaProdutosVenda = objeto.getListaProdutosVenda();
        this.valor = objeto.getValor();
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
