package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.ExperienciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IExperienciaRepository extends JpaRepository<ExperienciaEntity, UUID> {
}
