package com.example.portfolio.modelo.Dominio;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Contacto {
    private String name;
    private String email;
    private String description;
}
