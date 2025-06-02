package com.rods.meu_leitor.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_capitulos")
public class Capitulo {

    public Capitulo() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String titulo;

    private String conteudo;
    
}
