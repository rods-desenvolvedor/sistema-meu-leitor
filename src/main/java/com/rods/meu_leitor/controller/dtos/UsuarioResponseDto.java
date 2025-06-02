package com.rods.meu_leitor.controller.dtos;

import java.util.List;

import com.rods.meu_leitor.entity.Historia;
import com.rods.meu_leitor.entity.Usuario;

public record UsuarioResponseDto(String nomeUsuario, String email, String senha, int idade, List<Historia> historias) {

    public UsuarioResponseDto(Usuario usuario)
    {
        this(usuario.getNomeUsuario(), usuario.getEmail(), usuario.getSenha(), usuario.getIdade(), usuario.getHistorias());
    }
    
}
