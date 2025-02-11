package com.sura.global_web.planes;

import com.sura.global_web.coberturas.Cobertura;
import com.sura.global_web.subramos.SubRamos;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private SubRamos subRamos;
    @OneToMany(mappedBy = "plan")
    private List<Cobertura>coberturas;

}
