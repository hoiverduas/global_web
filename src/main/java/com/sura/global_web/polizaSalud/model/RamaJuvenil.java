package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@DiscriminatorValue("RAMA_JUVENIL")
@Table(name = "ramaJuvenil")
@Data
@Entity
public class RamaJuvenil extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaJuvenil subRamaJuvenil;
    @ElementCollection
    private List<String> PlanRamaJuvenil;
    @ElementCollection
    private List<String> coberturaRamaJuvenil;
}
