package com.sura.global_web.plans.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "planPacFamily")
@DiscriminatorValue("PLAN_PAC_FAMILY")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlanPacFamily extends Plan {
    
    @ElementCollection
    private List<String> coberturaPacFamily;
    @ManyToOne
    @JsonBackReference
    private RamaPacFamily ramaPacFamily;

}
