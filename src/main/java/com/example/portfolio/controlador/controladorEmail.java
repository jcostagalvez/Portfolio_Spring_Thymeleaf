package com.example.portfolio.controlador;

import com.example.portfolio.modelo.Dominio.Contacto;
import com.example.portfolio.modelo.Dominio.Email;
import com.example.portfolio.servicio.I_ServicioEmail;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

@Data
@RestController
public class controladorEmail {
    private I_ServicioEmail servicioEmail;
    @Value("${email.sender}")
    private String email;

    public controladorEmail(I_ServicioEmail servicioEmail){
        this.servicioEmail = servicioEmail;
    }
    @PostMapping("/sendContactoEmail")
    public ResponseEntity<?> send(@ModelAttribute Contacto contacto){
        System.out.println("Este es el contacto ---> " + contacto);
        Context contexto = new Context();
        contexto.setVariable("email", contacto.getEmail());
        contexto.setVariable("name", contacto.getName());
        contexto.setVariable("message", contacto.getDescription());
        System.out.println("Description" + contacto.getDescription());
        try {
            //Email a nosotros por la informacion
            servicioEmail.sendEmailWithtemplate(email, "Nueva solicitud de contacto: " + contacto.getName(), "TemplateEmail", contexto);
            //Email para el usuario diciendo que en breves se le contactara
            servicioEmail.sendEmailWithtemplate(contacto.getEmail(), "NoReply contacto al portfolio", "NoReplyTemplate", contexto);
            return ResponseEntity.status(201).body("Email enviado con Subject:  " + contacto.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending email: " + e.getMessage());
        }
    }

}
