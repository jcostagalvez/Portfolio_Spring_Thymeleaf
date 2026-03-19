package com.example.portfolio.modelo.Entity;

import com.example.portfolio.modelo.Dominio.Tecnologia;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "certificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificacionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "certificacionidentificator")
    private String certificacionidentificator;

    @Column(name = "expirationdate")
    private Date expirationdate;


    @ManyToOne
    @JoinColumn(name = "tecnologiaid", nullable = false)
    private TecnologiaEntity tecnologia;


}