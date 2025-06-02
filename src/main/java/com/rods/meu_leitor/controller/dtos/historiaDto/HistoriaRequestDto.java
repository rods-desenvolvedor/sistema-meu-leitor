package com.rods.meu_leitor.controller.dtos.historiaDto;

import com.rods.meu_leitor.entity.enums.Genero;

import jakarta.validation.constraints.NotBlank;

public record HistoriaRequestDto(
    
    @NotBlank(message = "O titulo é obrigatório")
    String titulo,

    @NotBlank(message = "A descrição é obrigatória")
    String descricao,

    
    Genero genero) {
    
}
