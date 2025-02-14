package com.sura.global_web.planComplement.model;


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
      @OneToMany(mappedBy = "ramaPacColective")
      private List<PlanPacColective> pacColectives;


}
