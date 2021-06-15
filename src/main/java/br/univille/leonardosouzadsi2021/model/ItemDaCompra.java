package br.univille.leonardosouzadsi2021.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemDaCompra {
    
    @Id
    private long idProduto;
    private int qtdCompra;
    private float precoUnitario;
    
    public long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    public int getQtdCompra() {
        return qtdCompra;
    }
    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }
    public float getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
