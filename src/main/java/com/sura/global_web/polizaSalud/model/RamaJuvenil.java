package com.sura.global_web.polizaSalud.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.plans.model.PlanRentaDiaria;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import com.sura.global_web.plans.model.PlanJuvenil;
import lombok.experimental.SuperBuilder;


@DiscriminatorValue("RAMA_JUVENIL")
@Table(name = "ramaJuvenil")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class RamaJuvenil extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    @JsonProperty("subRamaJuvenil")
    private SubRamaJuvenil subRamaJuvenil;

    @OneToMany(mappedBy = "ramaJuvenil", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PlanJuvenil> planJuvenils;

    public void addPlanJuvenil(PlanJuvenil plan) {
        plan.setRamaJuvenil(this); // Establecer relación bidireccional
        this.planJuvenils.add(plan);
    }

}
