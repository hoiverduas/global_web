package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


import com.sura.global_web.plans.model.PlanRentaDiaria;

@Data
@Entity
@DiscriminatorValue("RAMA_RENTA_DIARIA")
@Table(name = "ramaRentaDiaria")
public class RamaRentaDiaria extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaRentaDiaria subRamaRentaDiaria;
    @OneToMany(mappedBy = "ramaRentaDiaria")
    private List<PlanRentaDiaria> planRentaDiarias;
    
}
