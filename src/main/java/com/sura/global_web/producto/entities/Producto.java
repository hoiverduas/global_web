package com.sura.global_web.producto.entities;


import com.sura.global_web.ramos.Ramos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "producto")
    List<Ramos>ramos = new ArrayList<>();

}
