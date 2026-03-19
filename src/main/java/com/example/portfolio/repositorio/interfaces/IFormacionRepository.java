package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Dominio.Formacion;
import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.FormacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IFormacionRepository extends JpaRepository<FormacionEntity, UUID> {
}
