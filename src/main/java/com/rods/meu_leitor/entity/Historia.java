package com.rods.meu_leitor.entity;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rods.meu_leitor.entity.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historias")
public class Historia {

    public Historia() {}

    

    public Historia(UUID id, String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.autor = autor;
    }

     public Historia(String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.autor = autor;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private Genero genero;

    private Usuario autor;


    
}
