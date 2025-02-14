package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import com.sura.global_web.plans.model.PlanJuvenil;

@DiscriminatorValue("RAMA_JUVENIL")
@Table(name = "ramaJuvenil")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RamaJuvenil extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaJuvenil subRamaJuvenil;
    @OneToMany(mappedBy = "ramaJuvenil")
    private List<PlanJuvenil> planJuvenils;
}
