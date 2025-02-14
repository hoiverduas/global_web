package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ramaClassicColective")
@DiscriminatorValue("RAMA_CLASSIC_COLECTIVE")
public class RamaClassicColective extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaClassicColective subRamaClassicColective;
    @ElementCollection
    private List<String> PlanClassicColective;
    @ElementCollection
    private List<String> coberturaClassicColective;

}
