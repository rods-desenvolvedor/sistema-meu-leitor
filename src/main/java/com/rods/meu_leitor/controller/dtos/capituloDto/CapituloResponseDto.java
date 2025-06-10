package com.rods.meu_leitor.controller.dtos.capituloDto;

import java.util.UUID;

import com.rods.meu_leitor.entity.Capitulo;
import com.rods.meu_leitor.entity.enums.Status;

public record CapituloResponseDto(UUID id,String titulo, String conteudo, Status status) {

    public CapituloResponseDto(Capitulo capitulo)
    {
        this(capitulo.getId(),capitulo.getTitulo(), capitulo.getConteudo(), capitulo.getStatus());
    }
    
}
