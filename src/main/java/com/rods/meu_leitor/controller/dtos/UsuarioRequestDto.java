package com.rods.meu_leitor.controller.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDto(

    @NotBlank(message = "Nome de usuario é obrigatório")
    String nomeUsuario,

    @Email(message = "Email invalido")
    @NotBlank(message = "Email é obrigatório")
    String email,

    @NotBlank(message = "Senha é obrigatória")
    String senha,

    @NotNull(message = "Senha é obrigatória")
    @Min(value = 1, message = "Idade deve ser maior que zero")
    Integer idade
    ) {
    
}
