package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.FormacionEntity;
import com.example.portfolio.repositorio.interfaces.ICertificacionRepository;
import com.example.portfolio.repositorio.interfaces.IFormacionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormacionServicio implements I_FormacionServicio{
    private IFormacionRepository repository;
    FormacionServicio(IFormacionRepository repository){
        this.repository = repository;
    }
    public List<FormacionEntity> getAllFormacionesOrderByDate(){
        return repository.findAll(
                Sort.by(Sort.Order.desc("endDate"))

        );
    }
}
