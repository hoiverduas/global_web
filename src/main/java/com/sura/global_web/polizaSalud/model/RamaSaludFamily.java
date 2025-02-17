package com.sura.global_web.polizaSalud.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.plans.model.PlanPacFamily;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


import com.sura.global_web.plans.model.PlanFamily;
import lombok.experimental.SuperBuilder;


@Table(name = "RamaSaludFamilies" )
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("RAMA_SALUD_FAMILY")

public class RamaSaludFamily extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaSaludFamily subRamaSaludFamily;

    @OneToMany(mappedBy = "ramaSaludFamilies", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PlanFamily> planFamilies;

    public void addPlanSaludFamily(PlanFamily plan) {
        plan.setRamaSaludFamilies(this); // Establecer relación bidireccional
        this.planFamilies.add(plan);
    }


}
