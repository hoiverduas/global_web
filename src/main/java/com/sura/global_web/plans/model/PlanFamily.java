package com.sura.global_web.plans.model;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaJuvenil;
import com.sura.global_web.polizaSalud.model.RamaSaludFamily;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("PLAN_FAMILY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planFamily")
public class PlanFamily extends Plan {

     @ElementCollection
    private List<String> coberturaPlanFamily;
    @ManyToOne
    private RamaSaludFamily ramaSaludFamilies;
    
}
