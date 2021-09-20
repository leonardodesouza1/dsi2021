package br.univille.leonardosouzadsi2021.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemDaCompra implements Serializable, GenericEntity<ItemDaCompra> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Produto produto;

    private int quantidade;

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void update(ItemDaCompra objeto) {
        this.id = objeto.getId();
        this.produto = objeto.getProduto();
        this.quantidade = objeto.getQuantidade();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public ItemDaCompra createNewInstance() {
        ItemDaCompra newInstance = new ItemDaCompra();
        newInstance.update(this);
        return newInstance;
    }
}
