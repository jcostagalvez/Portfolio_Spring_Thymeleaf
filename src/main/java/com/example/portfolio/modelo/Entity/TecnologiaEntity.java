package com.example.portfolio.modelo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tecnologia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TecnologiaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "experience")
    private Integer experience;

    @OneToMany(mappedBy = "tecnologia") //nombre del campo en JPA
    private List<CertificacionEntity> certificaciones;


}