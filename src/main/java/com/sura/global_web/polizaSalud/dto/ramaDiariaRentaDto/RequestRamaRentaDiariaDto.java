package com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto;

import com.sura.global_web.plans.model.PlanRentaDiaria;
import com.sura.global_web.polizaSalud.model.SubRamaRentaDiaria;
import lombok.Data;

import java.util.List;

@Data
public class RequestRamaRentaDiariaDto {


    private SubRamaRentaDiaria subRamaRentaDiaria;
    private List<PlanRentaDiaria> planRentaDiarias;
    private String characteristics;
}
