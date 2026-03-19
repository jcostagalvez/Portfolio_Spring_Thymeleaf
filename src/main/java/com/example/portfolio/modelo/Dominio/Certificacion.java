package com.example.portfolio.modelo.Dominio;

import java.util.UUID;

public class Certificacion {

    private UUID id;
    private String name;
    private String technology;
    private String imageUrl; // mejor que Image

    public Certificacion() {}

    public Certificacion(UUID id, String name, String technology, String imageUrl) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.imageUrl = imageUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTechnology() {
        return technology;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}