package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Entity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface I_proyectoRepository extends JpaRepository<ProyectoEntity, UUID> {
}
