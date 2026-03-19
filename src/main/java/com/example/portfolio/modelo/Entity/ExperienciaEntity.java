package com.example.portfolio.modelo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "experiencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExperienciaEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "company")
    private String company;

    @Column(name = "job")
    private String job;

    @Column(name = "startdate")
    private LocalDate startdate;

    @Column(name = "enddate")
    private LocalDate  enddate;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;


}