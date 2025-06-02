package com.rods.meu_leitor.controller.dtos.historiaDto;

import java.time.LocalDateTime;

import com.rods.meu_leitor.entity.Historia;

public record HistoriaResponseDto(String titulo, String descricao, LocalDateTime dataCriacao) {

    public HistoriaResponseDto(Historia historia)
    {
        this(historia.getTitulo(), historia.getDescricao(), historia.getDataCriacao());
    }
    
}
