package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICertificacionRepository extends JpaRepository<CertificacionEntity, UUID> {
}
