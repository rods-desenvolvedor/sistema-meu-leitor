package com.rods.meu_leitor.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.rods.meu_leitor.controller.dtos.capituloDto.CapituloRequestDto;
import com.rods.meu_leitor.controller.dtos.historiaDto.HistoriaRequestDto;
import com.rods.meu_leitor.service.HistoriaService;


@Controller
@RequestMapping("/minha-historia")
public class MinhaHistoriaController {

    private final HistoriaService historiaService;

    public MinhaHistoriaController(HistoriaService historiaService)
    {
        this.historiaService = historiaService;
    }


    @GetMapping("/listar")
    public String minhasHistorias(Model model,Principal principal)
    {
        model.addAttribute("historias", historiaService.listarHistoriasUsuarioLogado(principal.getName()));
        return "minha-historia/minhas-historias";
    }

    @GetMapping("/{id}")
    public String continuarEscrevendoHistoria(Model model, @PathVariable UUID id)
    {
        System.out.println(id);
        model.addAttribute("historia", historiaService.listarHistoriaPeloId(id));
        return "minha-historia/continuar-escrevendo";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCapitulo(@PathVariable UUID id, Model model)
    {
        model.addAttribute("capitulo", historiaService.buscarCapituloPeloId(id));
        return "minha-historia/editar-capitulo";
    }

    @PostMapping("/editar/{id}")
    public String salvarCapituloEditado(@PathVariable UUID id, @ModelAttribute CapituloRequestDto capituloRequestDto)
    {
        historiaService.editarCapitulo(id, capituloRequestDto);
        return "redirect:/minha-historia/listar";
    }

    @GetMapping("/form-cadastrar")
    public String historia(Model model)
    {
        model.addAttribute("historiaRequestDto", new HistoriaRequestDto(null, null, null));
        return "minha-historia/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarHistoria(@ModelAttribute HistoriaRequestDto historiaRequestDto, Principal principal)
    {
        historiaService.cadastrarHistoria(principal.getName(), historiaRequestDto);
        return "redirect:/minha-historia/listar";
    }

    @GetMapping("/form-cadastrar-capitulo/{id}")
    public String formularioCadastrarCapitulo(Model model, @PathVariable UUID id)
    {
        model.addAttribute("capituloRequestDto", new CapituloRequestDto(null, null));
        model.addAttribute("idHistoria", id);
        return "minha-historia/novo-capitulo";
    }

    @PostMapping("/cadastrar-capitulo")
    public String cadastrarCapitulo(@RequestParam UUID id ,Model model, @ModelAttribute CapituloRequestDto capituloRequestDto)
    {
        historiaService.cadastrarCapitulo(capituloRequestDto, id);
        model.addAttribute("historia", historiaService.listarHistoriaPeloId(id));
        return "minha-historia/continuar-escrevendo";
    }

    
}
