package com.rods.meu_leitor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rods.meu_leitor.controller.dtos.capituloDto.CapituloRequestDto;
import com.rods.meu_leitor.controller.dtos.capituloDto.CapituloResponseDto;
import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaRequestDto;
import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaResponseDto;
import com.rods.meu_leitor.entity.Capitulo;
import com.rods.meu_leitor.entity.Historia;
import com.rods.meu_leitor.entity.Usuario;
import com.rods.meu_leitor.entity.enums.Status;
import com.rods.meu_leitor.repository.CapituloRepository;
import com.rods.meu_leitor.repository.HistoriaRepository;
import com.rods.meu_leitor.repository.UsuarioRepository;

@Service
public class HistoriaService {

    private final HistoriaRepository historiaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CapituloRepository capituloRepository;

    public HistoriaService(HistoriaRepository historiaRepository, UsuarioRepository usuarioRepository, CapituloRepository capituloRepository)
    {
        this.historiaRepository = historiaRepository;
        this.usuarioRepository = usuarioRepository;
        this.capituloRepository = capituloRepository;
    }


    public HistoriaResponseDto cadastrarHistoria(String email, HistoriaRequestDto historiaRequestDto)
    {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        

        Historia historia  = new Historia(historiaRequestDto.titulo(),
        historiaRequestDto.descricao(), LocalDateTime.now() , historiaRequestDto.genero(), usuario, new ArrayList<>(), Status.RASCUNHO);

        Capitulo capituloPadrao = new Capitulo("Capitulo 1 - Padrão", "Comece a escrever usa historia", historia, Status.RASCUNHO);
        historia.getCapitulos().add(capituloPadrao);

        Historia historiaSalva = historiaRepository.save(historia);

        return new HistoriaResponseDto(historiaSalva);
    }

    public List<HistoriaResponseDto> listarTodasAsHistorias()
    {
        List<Historia> historias = historiaRepository.findAll();

        return historias.stream().map(HistoriaResponseDto::new).toList();
    }

    public List<HistoriaResponseDto> listarHistoriasUsuarioLogado(String email)
    {
        Usuario usuario = usuarioRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuario com esse email não encontrado"));

        List<Historia> historias =  historiaRepository.findAllByUsuarioId(usuario.getId());

        return historias.stream().map(HistoriaResponseDto::new).toList();
    }

    public HistoriaResponseDto listarHistoriaPeloId(UUID id)
    {
        Historia historia = historiaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Historia não encontrada"));

        return new HistoriaResponseDto(historia);
    }

    public CapituloResponseDto cadastrarCapitulo(CapituloRequestDto capituloRequestDto, UUID idHistoria)
    {
        Historia historia = historiaRepository.findById(idHistoria)
        .orElseThrow(() -> new RuntimeException("Historia não foi encontrada"));

        Capitulo capitulo = new Capitulo(capituloRequestDto.titulo(), capituloRequestDto.conteudo(), historia, Status.RASCUNHO);

        capituloRepository.save(capitulo);

        return new CapituloResponseDto(capitulo);
    }

    public CapituloResponseDto buscarCapituloPeloId(UUID id)
    {
        Capitulo capitulo = capituloRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Capitulo não foi encontrado"));

        return new CapituloResponseDto(capitulo);
    }

    public CapituloResponseDto editarCapitulo(UUID id, CapituloRequestDto capituloRequestDto)
    {
        Capitulo capitulo = capituloRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Capitulo não foi encontrado"));
        

        capitulo.setTitulo(capituloRequestDto.titulo());
        capitulo.setConteudo(capituloRequestDto.conteudo());

        capituloRepository.save(capitulo);

        return new CapituloResponseDto(capitulo);
    }
    
}
