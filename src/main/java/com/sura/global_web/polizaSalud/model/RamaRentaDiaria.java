package com.sura.global_web.polizaSalud.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sura.global_web.plans.model.PlanJuvenil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


import com.sura.global_web.plans.model.PlanRentaDiaria;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@DiscriminatorValue("RAMA_RENTA_DIARIA")
@Table(name = "ramaRentaDiaria")
@AllArgsConstructor
@NoArgsConstructor

public class RamaRentaDiaria extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaRentaDiaria subRamaRentaDiaria;

    @OneToMany(mappedBy = "ramaRentaDiaria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PlanRentaDiaria> planRentaDiarias;

    public void addPlanRentaDiaria(PlanRentaDiaria plan) {
        plan.setRamaRentaDiaria(this); // Establecer relación bidireccional
        this.planRentaDiarias.add(plan);
    }



}
