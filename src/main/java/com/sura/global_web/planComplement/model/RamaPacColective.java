package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

<<<<<<< HEAD
import com.sura.global_web.plans.model.PlanPacColective;

=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1
@Entity
@Table(name = "ramaPacColective")
@DiscriminatorValue("RAMA_PAC_COLECTIVE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamaPacColective extends PlanComplement{

      @Enumerated(EnumType.STRING)
      private SubRamaPacColective subRamaPacColective;
<<<<<<< HEAD
      @OneToMany(mappedBy = "ramaPacColective")
      private List<PlanPacColective> pacColectives;
=======
      @ElementCollection
      private List<String> PlanPacColective;
      @ElementCollection
      private List<String> coberturaPacColective;
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1


}
