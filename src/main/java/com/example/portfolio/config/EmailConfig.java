package com.example.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
//CONFIGURACION DEL EMAIL SENDER
@Configuration
public class EmailConfig {
    @Value("${email.sender}")
    private String emailFrom;
    @Value("${email.password}")
    private String emailPassword;
    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
        //Este host es solo para email nuscar cual seria el otro
        mailsender.setHost("smtp.gmail.com");
        mailsender.setPort(587);
        mailsender.setUsername(emailFrom);
        mailsender.setPassword(emailPassword);
        Properties propertyMailSender =  mailsender.getJavaMailProperties();
        propertyMailSender.put("mail.transport.protocol", "smtp");
        propertyMailSender.put("mail.smtp.auth", "true");
        propertyMailSender.put("mail.smtp.starttls.enable", "true");
        propertyMailSender.put("mail.smtp.starttls.required", "true");
        propertyMailSender.put("mail.debug", "true");
        return mailsender;

    }
}
