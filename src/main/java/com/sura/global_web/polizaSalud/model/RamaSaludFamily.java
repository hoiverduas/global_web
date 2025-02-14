package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

<<<<<<< HEAD
import com.sura.global_web.plans.model.PlanFamily;

=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@Table(name = "RamaSaludFamilies" )
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("RAMA_SALUD_FAMILY")
public class RamaSaludFamily extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaSaludFamily subRamaSaludFamily;
<<<<<<< HEAD
    @OneToMany(mappedBy = "ramaSaludFamilies")
    private List<PlanFamily> planFamilies;
=======
    @ElementCollection
    private List<String> PlanRamaSaludFamily;
    @ElementCollection
    private List<String> coberturaRamaSaludFamily;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1

}
