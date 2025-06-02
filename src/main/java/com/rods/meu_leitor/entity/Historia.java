package com.rods.meu_leitor.entity;


import java.time.LocalDateTime;
import java.util.UUID;

import com.rods.meu_leitor.entity.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historias")
public class Historia {

    public Historia() {}

    

    public Historia(UUID id, String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.usuario = usuario;
    }

     public Historia(String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.usuario = usuario;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getDescricao() {
        return descricao;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }



    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }



    public Genero getGenero() {
        return genero;
    }



    public void setGenero(Genero genero) {
        this.genero = genero;
    }



    public Usuario getUsuario() {
        return usuario;
    }



    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    


    
}
