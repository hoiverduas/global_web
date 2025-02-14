package com.sura.global_web.plans.model;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaClassicColective;

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
@DiscriminatorValue("PLAN_CLASSIC_COLECTIVE")
@Table(name = "plansClassicColective")
@Entity
public class PlanClassicColective extends Plan{

    @ElementCollection
    private List<String> coberturaClassicColection;
    @ManyToOne
    private RamaClassicColective ramaClassicColective;
}
