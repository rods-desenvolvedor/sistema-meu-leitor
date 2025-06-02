package com.rods.meu_leitor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaRequestDto;
import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaResponseDto;
import com.rods.meu_leitor.entity.Capitulo;
import com.rods.meu_leitor.entity.Historia;
import com.rods.meu_leitor.entity.Usuario;
import com.rods.meu_leitor.repository.HistoriaRepository;
import com.rods.meu_leitor.repository.UsuarioRepository;

@Service
public class HistoriaService {

    private final HistoriaRepository historiaRepository;
    private final UsuarioRepository usuarioRepository;

    public HistoriaService(HistoriaRepository historiaRepository, UsuarioRepository usuarioRepository)
    {
        this.historiaRepository = historiaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public HistoriaResponseDto cadastrarHistoria(UUID idUsuario, HistoriaRequestDto historiaRequestDto)
    {

        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        

        Historia historia  = new Historia(historiaRequestDto.titulo(),
        historiaRequestDto.descricao(), LocalDateTime.now() , historiaRequestDto.genero(), usuario, new ArrayList<>());

        Capitulo capituloPadrao = new Capitulo("Capitulo 1 - Padrão", "Comece a escrever usa historia", historia);
        historia.getCapitulos().add(capituloPadrao);

        Historia historiaSalva = historiaRepository.save(historia);

        return new HistoriaResponseDto(historiaSalva);
    }
    
}
