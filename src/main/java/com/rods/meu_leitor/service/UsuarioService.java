package com.rods.meu_leitor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rods.meu_leitor.controller.dtos.UsuarioRequestDto;
import com.rods.meu_leitor.controller.dtos.UsuarioResponseDto;
import com.rods.meu_leitor.entity.Capitulo;
import com.rods.meu_leitor.entity.Historia;
import com.rods.meu_leitor.entity.Usuario;
import com.rods.meu_leitor.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDto cadastrarUsuario(UsuarioRequestDto usuarioRequestDto)
    {
        if(usuarioRequestDto.idade() < 16)
        {
            throw new RuntimeException("Idade minima para cadastro é 16 anos");
        }

        List<Historia> historias = new ArrayList<>();

        Usuario usuario = new Usuario(usuarioRequestDto.nomeUsuario(),
        usuarioRequestDto.email(),usuarioRequestDto.senha(),usuarioRequestDto.idade(), historias);

        usuarioRepository.save(usuario);

        return new UsuarioResponseDto(usuario);
    }

    
}
