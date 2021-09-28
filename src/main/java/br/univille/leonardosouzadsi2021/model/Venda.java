package br.univille.leonardosouzadsi2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Vendas implements Serializable, GenericEntity<Vendas>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<PedidoDaVenda> pedidoDaVenda;
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
    public void update(Vendas objeto) {
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
    public Vendas createNewInstance() {
        Vendas newInstance = new Vendas();
        newInstance.update(this);
        return newInstance;
    }
}
