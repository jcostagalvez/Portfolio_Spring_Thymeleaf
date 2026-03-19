package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Entity.ProyectoEntity;
import com.example.portfolio.modelo.Entity.TecnologiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface I_TecnologiaRepository extends JpaRepository<TecnologiaEntity, UUID> {

}
