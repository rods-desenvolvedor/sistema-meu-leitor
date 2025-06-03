package com.rods.meu_leitor.controller.dtos.historiaDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.rods.meu_leitor.controller.dtos.capituloDto.CapituloResponseDto;
import com.rods.meu_leitor.entity.Historia;

public record HistoriaResponseDto(UUID id,String titulo, String descricao, LocalDateTime dataCriacao, List<CapituloResponseDto> capitulos) {

    public HistoriaResponseDto(Historia historia)
    {
        this(historia.getId(),historia.getTitulo(), historia.getDescricao(), historia.getDataCriacao(),
        historia.getCapitulos().stream().map(CapituloResponseDto::new).toList());
    }
    
}
