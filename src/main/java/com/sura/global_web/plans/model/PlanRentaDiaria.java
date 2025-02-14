package com.sura.global_web.plans.model;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaJuvenil;
import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("PLAN_RENTA_DIARIA")
@Entity
@Table(name = "planRentaDiaria")
public class PlanRentaDiaria extends Plan {
    
    
    @ElementCollection
    private List<String> coberturaPlanRenta;
    @ManyToOne
    private RamaRentaDiaria ramaRentaDiaria;


}
