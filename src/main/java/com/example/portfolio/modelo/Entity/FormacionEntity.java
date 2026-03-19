package com.example.portfolio.modelo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "formacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormacionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(columnDefinition = "TEXT", name = "description")
    private String description;

    @Column(name = "isoficial")
    private Boolean isoficial;


}