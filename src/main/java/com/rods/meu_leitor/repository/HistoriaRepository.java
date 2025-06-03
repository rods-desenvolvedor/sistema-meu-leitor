package com.rods.meu_leitor.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.meu_leitor.entity.Historia;

public interface HistoriaRepository extends JpaRepository<Historia, UUID>{

    List<Historia> findAllByUsuarioId(UUID id);
    
}
