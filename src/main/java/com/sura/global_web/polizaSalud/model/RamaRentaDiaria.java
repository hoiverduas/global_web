package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

<<<<<<< HEAD

import com.sura.global_web.plans.model.PlanRentaDiaria;

=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@Data
@Entity
@DiscriminatorValue("RAMA_RENTA_DIARIA")
@Table(name = "ramaRentaDiaria")
public class RamaRentaDiaria extends PolizaSalud{

    @Enumerated(EnumType.STRING)
    private SubRamaRentaDiaria subRamaRentaDiaria;
<<<<<<< HEAD
    @OneToMany(mappedBy = "ramaRentaDiaria")
    private List<PlanRentaDiaria> planRentaDiarias;
    
=======
    @ElementCollection
    private List<String> PlanRamaRentaDiaria;
    @ElementCollection
    private List<String> coberturaRamaRentaDiaria;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
}
