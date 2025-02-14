package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

<<<<<<< HEAD
import com.sura.global_web.plans.model.PlanClassicColective;

=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@Entity
@Data
@Table(name = "ramaClassicColective")
@DiscriminatorValue("RAMA_CLASSIC_COLECTIVE")
public class RamaClassicColective extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaClassicColective subRamaClassicColective;
<<<<<<< HEAD
    @OneToMany(mappedBy = "ramaClassicColective")
    private List<PlanClassicColective> planClassicColectives;
=======
    @ElementCollection
    private List<String> PlanClassicColective;
    @ElementCollection
    private List<String> coberturaClassicColective;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1

}
