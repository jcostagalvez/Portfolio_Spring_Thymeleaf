package com.example.portfolio.api;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.repositorio.interfaces.ICertificacionRepository;
import com.example.portfolio.servicio.certificacionServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Portfolio")
public class PortfolioApi {
    ICertificacionRepository _repository;

    PortfolioApi (ICertificacionRepository certificacionRepository){
        this._repository = certificacionRepository;

    }
    @GetMapping
    public List<CertificacionEntity> getListCertificacione(){
       return _repository.findAll();
    }
}
