package com.sura.global_web.polizaSalud.model;


import jakarta.persistence.*;
import lombok.Data;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("POLIZA_SALUD")
@Entity
@Table(name = "polizasSalud")
@DiscriminatorColumn(name = "type_polizaSalud")
@Data
public abstract class PolizaSalud  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private String characteristics;
=======
>>>>>>> 48261368eebb052b9864277916be46d9993a1bc1


}
