package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("RAMA_RENTA_DIARIA")
@Table(name = "ramaRentaDiaria")
public class RamaRentaDiaria extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaRentaDiaria subRamaRentaDiaria;
    @ElementCollection
    private List<String> PlanRamaRentaDiaria;
    @ElementCollection
    private List<String> coberturaRamaRentaDiaria;
}
