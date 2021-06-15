package br.univille.leonardosouzadsi2021.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
    
    @Id
    private long idProduto;
    private String nome;
    private float valor;

    public long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
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
