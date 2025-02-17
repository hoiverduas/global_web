package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("POLIZA_SALUD")
@Entity
@Table(name = "polizasSalud")
@DiscriminatorColumn(name = "type_polizaSalud")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PolizaSalud  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characteristics;


}
