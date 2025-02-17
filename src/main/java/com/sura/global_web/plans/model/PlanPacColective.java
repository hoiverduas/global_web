package com.sura.global_web.plans.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sura.global_web.planComplement.model.RamaPacColective;
import com.sura.global_web.planComplement.model.RamaPacFamily;

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
@DiscriminatorValue("PLAN_PAC_COLECTIVE")
@Table(name = "planPacColective")
@Entity
public class PlanPacColective extends Plan{
    

    @ElementCollection
    private List<String> coberturaPacColective;
    @ManyToOne
    @JsonBackReference
    private RamaPacColective ramaPacColective;

    public void setRamaPacColective(RamaPacColective rama){
        this.ramaPacColective = rama;
    }

}
