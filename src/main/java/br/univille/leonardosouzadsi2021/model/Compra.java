package br.univille.leonardosouzadsi2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Compra implements Serializable, GenericEntity<Compra> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;

    private String cnpj;
    private String nomeEmpresa;
    private float valorTotal;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Funcionario funcionario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="compra_id")
    private List<ItemDaCompra> listaItens = new ArrayList<ItemDaCompra>();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<ItemDaCompra> getListaItens() {
        return listaItens;
    }
    public void setListaItens(List<ItemDaCompra> listaItens) {
        this.listaItens = listaItens;
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
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public void update(Compra objeto) {

    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Compra createNewInstance() {
        Compra newInstance = new Compra();
        newInstance.update(this);
        return newInstance;
    }
}
