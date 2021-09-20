package br.univille.leonardosouzadsi2021.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Funcionario implements Serializable, GenericEntity<Funcionario> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private float comissao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getComissao() {
        return comissao;
    }
    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void update(Funcionario objeto) {
        this.email = objeto.getEmail();
        this.comissao = objeto.getComissao();
        this.nome = objeto.getNome();
        this.endereco = objeto.getEndereco();
        this.telefone = objeto.getTelefone();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Funcionario createNewInstance() {
        Funcionario newInstance = new Funcionario();
        newInstance.update(this);
        return newInstance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
