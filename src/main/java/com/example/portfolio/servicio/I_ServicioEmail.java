package com.example.portfolio.servicio;

import jakarta.mail.MessagingException;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.List;

public interface I_ServicioEmail {
    void sendEmail(String toUser, String subject, String body);
    void sendEmailWithtemplate(String toUser, String subject, String template, Context context) throws MessagingException;
    void sendEmailWithFile (String toUser, String subject, String body, File file) throws MessagingException;
}
