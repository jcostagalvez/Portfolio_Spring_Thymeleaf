package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.ExperienciaEntity;
import com.example.portfolio.modelo.Entity.ProyectoEntity;
import com.example.portfolio.repositorio.interfaces.IExperienciaRepository;
import com.example.portfolio.repositorio.interfaces.I_proyectoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServicio implements I_ProyectoServicio{

    private I_proyectoRepository repositorio;

    ProyectoServicio(I_proyectoRepository repositorio){
        this.repositorio = repositorio;
    }

    public List<ProyectoEntity> GetAll(){
        return repositorio.findAll();
    }
}
