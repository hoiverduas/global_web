package com.sura.global_web.planComplement.dto.ramaPacColective;

import com.sura.global_web.planComplement.model.SubRamaPacColective;
import com.sura.global_web.plans.model.PlanPacColective;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestRamaPacColective {

    private String characteristics;
    private SubRamaPacColective subRamaPacColective;
    private List<PlanPacColective> pacColectives = new ArrayList<>();
}
