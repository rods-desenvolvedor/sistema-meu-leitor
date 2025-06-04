package com.rods.meu_leitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rods.meu_leitor.controller.dtos.UsuarioRequestDto;
import com.rods.meu_leitor.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String usuario(Model model)
    {
        model.addAttribute("usuarioRequestDto", new UsuarioRequestDto(null, null, null, null));
        return "auth/cadastrar";
    }


    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid @ModelAttribute("usuarioRequestDto") UsuarioRequestDto usuarioRequestDto, BindingResult result)
    {

        if(result.hasErrors())
        {
            return "usuario/index";
        }

        usuarioService.cadastrarUsuario(usuarioRequestDto);

        return "redirect:/usuario/";

    }
    
}
