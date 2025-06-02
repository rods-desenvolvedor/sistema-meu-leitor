package com.rods.meu_leitor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.meu_leitor.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{
    
}
