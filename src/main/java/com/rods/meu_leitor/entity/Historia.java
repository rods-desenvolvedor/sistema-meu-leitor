package com.rods.meu_leitor.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.rods.meu_leitor.entity.enums.Genero;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historias")
public class Historia {

    public Historia() {}

    

    public Historia(UUID id, String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario usuario, List<Capitulo> capitulos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.usuario = usuario;
        this.capitulos = capitulos;
    }

     public Historia(String titulo, String descricao, LocalDateTime dataCriacao, Genero genero, Usuario usuario, List<Capitulo> capitulos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.usuario = usuario;
        this.capitulos = capitulos;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;
    private String descricao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "historia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Capitulo> capitulos = new ArrayList<>();

    



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



    public List<Capitulo> getCapitulos() {
        return capitulos;
    }



    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    


    
}
