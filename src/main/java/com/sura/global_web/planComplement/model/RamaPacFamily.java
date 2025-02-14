package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

<<<<<<< HEAD
import com.sura.global_web.plans.model.PlanPacFamily;

=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@Entity
@Table(name = "ramaPacFamily")
@DiscriminatorValue("RAMA_PAC_FAMILY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamaPacFamily extends PlanComplement{

    @Enumerated(EnumType.STRING)
    private SubRamaPacFamily subRamaPacFamily;
<<<<<<< HEAD
    @OneToMany(mappedBy = "ramaPacFamily")
    private List<PlanPacFamily> pacFamilies;
=======
    @ElementCollection
    private List<String> PlanPacFamily;
    @ElementCollection
    private List<String> coberturaPacFamily;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1

}
