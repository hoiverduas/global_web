package com.sura.global_web.polizaSalud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sura.global_web.polizaSalud.model.RamaSaludFamily;

public interface IRamaSaludFamilyRepository extends JpaRepository<RamaSaludFamily,Long> {
    
}
