package br.univille.leonardosouzadsi2021.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Produto implements Serializable, GenericEntity<Produto> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float valor;


    @Override
    public void update(Produto produto) {
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public Produto createNewInstance() {
        Produto newInstance = new Produto();
        newInstance.update(this);
        return newInstance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}
