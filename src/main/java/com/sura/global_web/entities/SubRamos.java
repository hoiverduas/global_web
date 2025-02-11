package com.sura.global_web.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subRamos")
public class SubRamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String codigo;
    @ManyToOne
    private Ramos ramos;
    @OneToMany(mappedBy = "subRamos")
    private List<Plan>planes;

}
