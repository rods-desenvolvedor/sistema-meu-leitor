package com.rods.meu_leitor.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rods.meu_leitor.controller.dtos.UsuarioRequestDto;
import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaRequestDto;
import com.rods.meu_leitor.service.HistoriaService;

@Controller
@RequestMapping("/historia")
public class HistoriaController {

    private final HistoriaService historiaService;

    public HistoriaController(HistoriaService historiaService)
    {
        this.historiaService = historiaService;
    }

    @GetMapping("/")
    public String minhasHistorias()
    {
        return "historia/index";
    }

    @GetMapping("/nova-historia")
    public String historia(Model model)
    {
        model.addAttribute("historiaRequestDto", new HistoriaRequestDto(null, null, null));
        return "historia/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarHistoria(@ModelAttribute HistoriaRequestDto historiaRequestDto, Principal principal)
    {
        historiaService.cadastrarHistoria(principal.getName(), historiaRequestDto);
        return "redirect:/historia/";
    }
    
}
