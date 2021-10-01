package br.univille.leonardosouzadsi2021.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable, GenericEntity<Cliente>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String cpf;

    private String nome;
    private String telefone;
    private String endereco;
    private String email;


    @Override
    public void update(Cliente objeto) {
        this.cpf = objeto.getCpf();
        this.email = objeto.getEmail();
        this.endereco = objeto.getEndereco();
        this.nome = objeto.getNome();
        this.telefone = objeto.getTelefone();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Cliente createNewInstance() {
        Cliente newInstance = new Cliente();
        newInstance.update(this);
        return newInstance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
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

}
