package com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto;

import com.sura.global_web.plans.model.PlanClassicColective;
import com.sura.global_web.polizaSalud.model.SubRamaClassicColective;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClassicColectiveDto {

    private Long id;
    private SubRamaClassicColective subRamaClassicColective;
    private List<PlanClassicColective> planClassicColectives = new ArrayList<>();
    private String characteristics;

}
