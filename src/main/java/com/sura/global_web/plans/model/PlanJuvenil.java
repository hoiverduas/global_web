package com.sura.global_web.plans.model;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaClassicColective;
import com.sura.global_web.polizaSalud.model.RamaJuvenil;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@DiscriminatorValue("PLAN_JUVENIL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planJuvenil")
public class PlanJuvenil extends Plan{
    

    @ElementCollection
    private List<String> coberturaPlanJuvenil;
    @ManyToOne
    private RamaJuvenil ramaJuvenil;

}
