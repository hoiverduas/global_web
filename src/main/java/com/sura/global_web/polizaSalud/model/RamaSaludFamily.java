package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Table(name = "RamaSaludFamilies" )
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("RAMA_SALUD_FAMILY")
public class RamaSaludFamily extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaSaludFamily subRamaSaludFamily;
    @ElementCollection
    private List<String> PlanRamaSaludFamily;
    @ElementCollection
    private List<String> coberturaRamaSaludFamily;

}
