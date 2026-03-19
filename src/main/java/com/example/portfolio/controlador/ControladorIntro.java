package com.example.portfolio.controlador;

import com.example.portfolio.modelo.Entity.CertificacionEntity;
import com.example.portfolio.modelo.Entity.ExperienciaEntity;
import com.example.portfolio.modelo.Entity.FormacionEntity;
import com.example.portfolio.modelo.Entity.ProyectoEntity;
import com.example.portfolio.servicio.I_CertificacionServicio;
import com.example.portfolio.servicio.I_ExperienciaServicio;
import com.example.portfolio.servicio.I_FormacionServicio;
import com.example.portfolio.servicio.I_ProyectoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/portfolio")
public class ControladorIntro {
    I_FormacionServicio formacion;
    I_ExperienciaServicio experiencia;
    I_ProyectoServicio proyecto;
    I_CertificacionServicio certificaciones;
    ControladorIntro(I_FormacionServicio formacion, I_ExperienciaServicio experiencia, I_ProyectoServicio proyecto, I_CertificacionServicio certificaciones){
        this.formacion = formacion;
        this.experiencia = experiencia;
        this.proyecto = proyecto;
        this.certificaciones = certificaciones;
    }

    @GetMapping("/")
    public String goHome (){
        return "home";
    }


    @GetMapping("/experiencia")
    public String goExperiencia (Model model){
        List<ExperienciaEntity> lstExperiencia = experiencia.GetAll();
        model.addAttribute("experiencias", lstExperiencia);
        return "experiencia";
    }

    @GetMapping("/formacion")
    public String goFormacion (Model model){
        List<FormacionEntity> lstFormacionOrder = formacion.getAllFormacionesOrderByDate();
        model.addAttribute("formaciones", lstFormacionOrder);
        return "formacion";
    }

    @GetMapping("/contacto")
    public String goContacto (Model model){
        return "contacto";
    }

    @GetMapping("/certificaciones")
    public String goCertificaciones (Model model){
        Map<String, List<CertificacionEntity>> mapCertByTech = certificaciones.getMapByTecnologia();
        List<CertificacionEntity> lstCertificaciones =         mapCertByTech.values()
                .stream()
                .flatMap(List::stream)
                .toList();
        model.addAttribute("certificaciones", lstCertificaciones);
        return "certificaciones";
    }

    @GetMapping("/desarollos")
    public String goDesarollos (Model model){
        List<ProyectoEntity> lstProyectos = proyecto.GetAll();
        model.addAttribute("proyectos", lstProyectos);
        return "proyectos";
    }

}
