package com.sura.global_web.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "coberturas")
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToOne
    private Plan plan;


}
