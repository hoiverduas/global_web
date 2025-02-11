package com.sura.global_web.ramos;


import com.sura.global_web.subramos.SubRamos;
import com.sura.global_web.producto.entities.Producto;
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
