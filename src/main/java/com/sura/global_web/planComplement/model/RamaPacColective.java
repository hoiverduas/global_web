package com.sura.global_web.planComplement.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.plans.model.PlanPacFamily;
import com.sura.global_web.plans.model.PlanRentaDiaria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import com.sura.global_web.plans.model.PlanPacColective;
@Entity
@Table(name = "ramaPacColective")
@DiscriminatorValue("RAMA_PAC_COLECTIVE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamaPacColective extends PlanComplement{

      @Enumerated(EnumType.STRING)
      private SubRamaPacColective subRamaPacColective;

      @OneToMany(mappedBy = "ramaPacColective", cascade = CascadeType.ALL, orphanRemoval = true)
      @JsonManagedReference
      private List<PlanPacColective> pacColectives;

      public void addPlanPacColective(PlanPacColective plan) {
            plan.setRamaPacColective(this); // Establecer relación bidireccional
            this.pacColectives.add(plan);
      }

}
