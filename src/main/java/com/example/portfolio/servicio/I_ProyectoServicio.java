package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.FormacionEntity;
import com.example.portfolio.modelo.Entity.ProyectoEntity;

import java.util.List;

public interface I_ProyectoServicio {
    public List<ProyectoEntity> GetAll();
}
