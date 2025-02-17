package com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sura.global_web.plans.model.PlanRentaDiaria;
import com.sura.global_web.polizaSalud.model.SubRamaRentaDiaria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;


@Data
public class ResponseRamaRentaDiariaDto {

    private Long id;
    private SubRamaRentaDiaria subRamaRentaDiaria;
    private List<PlanRentaDiaria> planRentaDiarias;
    private String characteristics;

}
