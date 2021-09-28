package br.univille.leonardosouzadsi2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Venda implements Serializable, GenericEntity<Venda>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name = "venda_id")
    private List<PedidoDaVenda> pedidoDaVenda = new ArrayList<>();
    private float valorTotal;

    public List<PedidoDaVenda> getPedidoDaVenda() {
        return pedidoDaVenda;
    }

    public void setPedidoDaVenda(List<PedidoDaVenda> pedidoDaVenda) {
        this.pedidoDaVenda = pedidoDaVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Cliente cliente;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Funcionario funcionario;

    public void setId(Long id) {
        this.id = id;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }



    @Override
    public void update(Venda objeto) {
        this.cliente = objeto.getCliente();
        this.pedidoDaVenda = objeto.getPedidoDaVenda();
        this.valorTotal = objeto.getValorTotal();
        this.funcionario = objeto.getFuncionario();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Venda createNewInstance() {
        Venda newInstance = new Venda();
        newInstance.update(this);
        return newInstance;
    }
}
