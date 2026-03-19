package com.example.portfolio.servicio;

import com.example.portfolio.modelo.Entity.FormacionEntity;
import jakarta.mail.MessagingException;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.List;

public interface I_FormacionServicio {
    public List<FormacionEntity> getAllFormacionesOrderByDate();
}
