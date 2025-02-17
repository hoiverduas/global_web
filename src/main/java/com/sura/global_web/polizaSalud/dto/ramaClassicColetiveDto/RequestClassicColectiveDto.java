package com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto;

import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.polizaSalud.model.SubRamaClassicColective;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestClassicColectiveDto {

    private SubRamaClassicColective subRamaClassicColective;
    private List<PlanClassicColective> planClassicColectives = new ArrayList<>();
    private String characteristics;
}
