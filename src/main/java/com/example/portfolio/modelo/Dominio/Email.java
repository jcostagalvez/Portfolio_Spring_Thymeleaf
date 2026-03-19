package com.example.portfolio.modelo.Dominio;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Email {
    private String toUser;
    private String subject;
    private String email;
    private String textBody;
    private String name;
}
