package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.Data;

@DiscriminatorValue("PLAN_COMPLEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "plansComplement")
@DiscriminatorColumn(name = "type_complement")
@Data
public abstract class PlanComplement  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characteristics;
}






