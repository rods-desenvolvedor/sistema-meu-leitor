package com.rods.meu_leitor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.meu_leitor.entity.Capitulo;

public interface CapituloRepository extends JpaRepository<Capitulo, UUID>{
    
}
