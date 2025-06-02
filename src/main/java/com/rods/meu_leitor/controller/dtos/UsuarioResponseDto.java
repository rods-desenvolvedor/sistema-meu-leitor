package com.rods.meu_leitor.controller.dtos;

import com.rods.meu_leitor.entity.Usuario;

public record UsuarioResponseDto(String nomeUsuario, String email, String senha, int idade) {

    public UsuarioResponseDto(Usuario usuario)
    {
        this(usuario.getNomeUsuario(), usuario.getEmail(), usuario.getSenha(), usuario.getIdade());
    }
    
}
