package com.rods.meu_leitor.controller.dtos.capituloDto;

import com.rods.meu_leitor.entity.Capitulo;

public record CapituloResponseDto(String titulo, String conteudo) {

    public CapituloResponseDto(Capitulo capitulo)
    {
        this(capitulo.getTitulo(), capitulo.getConteudo());
    }
    
}
