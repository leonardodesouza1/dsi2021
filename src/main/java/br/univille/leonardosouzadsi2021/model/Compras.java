package br.univille.leonardosouzadsi2021.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Compras {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCompras;
    private String cnpj;
    private String nomeEmpresa;
    private long idProduto;
    private float valorTotal;
    private long idFuncionario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemDaCompra> listaItens = new ArrayList<ItemDaCompra>(); 
    
    
    public List<ItemDaCompra> getListaItens() {
        return listaItens;
    }
    public void setListaItens(List<ItemDaCompra> listaItens) {
        this.listaItens = listaItens;
    }
    public long getIdCompras() {
        return idCompras;
    }
    public void setIdCompras(long idCompras) {
        this.idCompras = idCompras;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    public long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public long getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}
