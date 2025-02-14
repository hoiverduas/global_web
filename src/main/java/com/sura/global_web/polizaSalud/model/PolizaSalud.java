package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("POLIZA_SALUD")
@Entity
@Table(name = "polizasSalud")
@DiscriminatorColumn(name = "type_polizaSalud")
@Data
public abstract class PolizaSalud  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characteristics;


}
