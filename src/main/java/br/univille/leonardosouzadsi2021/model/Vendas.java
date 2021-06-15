package br.univille.leonardosouzadsi2021.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenda;
    private long idProduto;
    private int qtdProduto;
    private float valorTotal;
    private long idCliente; 
    private long idFuncionario;
    
    public long getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }
    public long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    public int getQtdProduto() {
        return qtdProduto;
    }
    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    public long getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    } 

    
}
