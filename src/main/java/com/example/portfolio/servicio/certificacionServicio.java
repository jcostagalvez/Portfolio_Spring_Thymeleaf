package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.TecnologiaEntity;
import com.example.portfolio.repositorio.interfaces.ICertificacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class certificacionServicio implements I_CertificacionServicio{
    private ICertificacionRepository repository;

    certificacionServicio(ICertificacionRepository repository){
        this.repository = repository;
    }

    public Map<String, List<CertificacionEntity>> getMapByTecnologia(){
        List<CertificacionEntity> lstCertificaciones = repository.findAll();
        return lstCertificaciones.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.getTecnologia().getName()
                        ));
    }
}
