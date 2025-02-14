package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import com.sura.global_web.plans.model.PlanJuvenil;

=======
import lombok.Data;


import java.util.List;

>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@DiscriminatorValue("RAMA_JUVENIL")
@Table(name = "ramaJuvenil")
@Data
@Entity
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
public class RamaJuvenil extends PolizaSalud {

    @Enumerated(EnumType.STRING)
    private SubRamaJuvenil subRamaJuvenil;
<<<<<<< HEAD
    @OneToMany(mappedBy = "ramaJuvenil")
    private List<PlanJuvenil> planJuvenils;
=======
    @ElementCollection
    private List<String> PlanRamaJuvenil;
    @ElementCollection
    private List<String> coberturaRamaJuvenil;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
}
