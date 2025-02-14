package com.sura.global_web.plans.model;

import java.util.List;

import com.sura.global_web.planComplement.model.RamaPacFamily;

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
    private RamaPacFamily ramaPacColective;

}
