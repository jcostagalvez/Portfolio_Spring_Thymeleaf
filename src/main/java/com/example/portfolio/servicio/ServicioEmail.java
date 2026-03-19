package com.example.portfolio.servicio;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.io.File;
@Service
public class ServicioEmail implements I_ServicioEmail{
    @Value("${email.sender}")
    private String emailFrom;
    @Autowired
    private JavaMailSender emailConfig;
    private  JavaMailSender mailSender;
    private  TemplateEngine templateEngine;
    @Autowired
    public ServicioEmail(JavaMailSender mailSender, TemplateEngine templateEngine){
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }
    @Override
    public void sendEmail(String toUser, String subject, String body ){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom(emailFrom);
        email.setTo(toUser);
        email.setSubject(subject);
        email.setText(body);

        emailConfig.send(email);

    }

    @Override
    public void sendEmailWithtemplate(String toUser, String subject, String template, Context context) throws MessagingException {
            MimeMessage config = mailSender.createMimeMessage();
            MimeMessageHelper email = new MimeMessageHelper(config);

            String htmlContent = templateEngine.process(template, context);
            email.setFrom(emailFrom);
            email.setTo(toUser);
            email.setSubject(subject);
            email.setText(htmlContent, true);
            mailSender.send(config);
    }

    @Override
    public void sendEmailWithFile(String toUser, String subject, String body, File file) throws MessagingException {
        MimeMessage config = mailSender.createMimeMessage();
        MimeMessageHelper email = new MimeMessageHelper(config);
        email.setFrom(emailFrom);
        email.setTo(toUser);
        email.setSubject(subject);
        email.setText(body);
        email.addAttachment(file.getName(), file);
        mailSender.send(config);
    }
}
