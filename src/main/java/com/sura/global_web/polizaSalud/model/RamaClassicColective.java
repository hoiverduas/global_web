package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.sura.global_web.plans.model.PlanClassicColective;

@Entity
@Data
@Table(name = "ramaClassicColective")
@DiscriminatorValue("RAMA_CLASSIC_COLECTIVE")
public class RamaClassicColective extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaClassicColective subRamaClassicColective;
    @OneToMany(mappedBy = "ramaClassicColective")
    private List<PlanClassicColective> planClassicColectives;

}
