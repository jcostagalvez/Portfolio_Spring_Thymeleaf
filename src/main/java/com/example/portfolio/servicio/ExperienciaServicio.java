package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.ExperienciaEntity;
import com.example.portfolio.repositorio.interfaces.IExperienciaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienciaServicio implements I_ExperienciaServicio{

    private IExperienciaRepository repositorio;

    ExperienciaServicio(IExperienciaRepository repositorio){
        this.repositorio = repositorio;
    }

    public List<ExperienciaEntity> GetAll(){
        return repositorio.findAll(
                Sort.by(Sort.Order.desc("enddate"))
        );
    }
}
