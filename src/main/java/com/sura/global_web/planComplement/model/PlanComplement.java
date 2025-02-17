package com.sura.global_web.planComplement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@DiscriminatorValue("PLAN_COMPLEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "plansComplement")
@DiscriminatorColumn(name = "type_complement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PlanComplement  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characteristics;
}






