package br.univille.leonardosouzadsi2021.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class MovimentacaoEstoque implements Serializable, GenericEntity<MovimentacaoEstoque> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Produto produto;

    @Temporal(value = TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;

    private int quantidade;

    private TipoMovimentacao tipoMovimentacao;

    public MovimentacaoEstoque(Produto produto, Date data, int quantidade, TipoMovimentacao tipoMovimentacao) {
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public MovimentacaoEstoque() {

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

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
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


    @Override
    public void update(MovimentacaoEstoque objeto) {
        this.data = objeto.getData();
        this.produto = objeto.getProduto();
        this.quantidade = objeto.getQuantidade();
        this.tipoMovimentacao = objeto.getTipoMovimentacao();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public MovimentacaoEstoque createNewInstance() {
        MovimentacaoEstoque newInstance = new MovimentacaoEstoque();
        newInstance.update(this);
        return newInstance;
    }
}
