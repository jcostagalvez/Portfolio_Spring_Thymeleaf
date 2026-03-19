package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.ProyectoEntity;

import java.util.List;
import java.util.Map;

public interface I_CertificacionServicio {
    public Map<String, List<CertificacionEntity>> getMapByTecnologia();
}
