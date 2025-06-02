package com.rods.meu_leitor.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    public Usuario() {}

    
    
    public Usuario(UUID id, String nomeUsuario, String email, String senha, int idade, List<Historia> historias) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.historias = historias;
    }

        public Usuario(String nomeUsuario, String email, String senha, int idade, List<Historia> historias) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.historias = historias;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nomeUsuario;
    private String email;
    private String senha;
    private int idade;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Historia> historias = new ArrayList<>();



    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }



    public String getNomeUsuario() {
        return nomeUsuario;
    }



    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getSenha() {
        return senha;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }



    public int getIdade() {
        return idade;
    }



    public void setIdade(int idade) {
        this.idade = idade;
    }



    public List<Historia> getHistorias() {
        return historias;
    }



    public void setHistorias(List<Historia> historias) {
        this.historias = historias;
    }

    

    
}
