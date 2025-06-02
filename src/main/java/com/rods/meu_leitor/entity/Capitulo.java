package com.rods.meu_leitor.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_capitulos")
public class Capitulo {

    public Capitulo() {}

    

    public Capitulo(UUID id, String titulo, String conteudo, Historia historia) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.historia = historia;
    }

      public Capitulo(String titulo, String conteudo, Historia historia) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.historia = historia;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private String conteudo;


    @ManyToOne
    @JoinColumn(name = "historia_id", nullable = false)
    private Historia historia;


    

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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }



    public Historia getHistoria() {
        return historia;
    }



    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    
    
}
