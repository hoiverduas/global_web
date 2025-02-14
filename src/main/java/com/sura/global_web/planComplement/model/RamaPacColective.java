package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ramaPacColective")
@DiscriminatorValue("RAMA_PAC_COLECTIVE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamaPacColective extends PlanComplement{

      @Enumerated(EnumType.STRING)
      private SubRamaPacColective subRamaPacColective;
      @ElementCollection
      private List<String> PlanPacColective;
      @ElementCollection
      private List<String> coberturaPacColective;


}
