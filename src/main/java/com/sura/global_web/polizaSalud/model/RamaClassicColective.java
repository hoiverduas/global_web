package com.sura.global_web.polizaSalud.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


import com.sura.global_web.plans.model.PlanClassicColective;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@Table(name = "ramaClassicColective")
@DiscriminatorValue("RAMA_CLASSIC_COLECTIVE")
@AllArgsConstructor
@NoArgsConstructor

public class RamaClassicColective extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaClassicColective subRamaClassicColective;

    @OneToMany(mappedBy = "ramaClassicColective", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PlanClassicColective> planClassicColectives = new ArrayList<>();

    public void addPlan(PlanClassicColective plan) {
        plan.setRamaClassicColective(this); // Establecer relación bidireccional
        this.planClassicColectives.add(plan);
    }

}
