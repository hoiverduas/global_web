package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ramaPacFamily")
@DiscriminatorValue("RAMA_PAC_FAMILY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamaPacFamily extends PlanComplement{

    @Enumerated(EnumType.STRING)
    private SubRamaPacFamily subRamaPacFamily;
    @ElementCollection
    private List<String> PlanPacFamily;
    @ElementCollection
    private List<String> coberturaPacFamily;

}
