package com.sura.global_web.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "ramos")
@Entity
public class Ramos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String codigo;
    @ManyToOne
    private Producto producto;
    @OneToMany(mappedBy = "ramos")
    private List<SubRamos>subRamos = new ArrayList<>();

}
