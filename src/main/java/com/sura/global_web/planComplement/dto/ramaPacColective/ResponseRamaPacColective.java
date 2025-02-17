package com.sura.global_web.planComplement.dto.ramaPacColective;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sura.global_web.planComplement.model.SubRamaPacColective;
import com.sura.global_web.plans.model.PlanPacColective;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseRamaPacColective {

    private Long id;
    private String characteristics;
    private SubRamaPacColective subRamaPacColective;
    private List<PlanPacColective> pacColectives = new ArrayList<>();

}
