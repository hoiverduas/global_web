package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaSaludFamily;

public interface IRamaSaludFamilyService {
    
    RamaSaludFamily createRamaSaludFamily(RamaSaludFamily ramaSaludFamily);
    List<RamaSaludFamily> findRamaSaludFamiliesAll();
    RamaSaludFamily findRamaSaludFamilyById(Long id);
    RamaSaludFamily updateRamaSaludFamily(Long id,RamaSaludFamily ramaSaludFamily);
    String deleteRamaSaludFamily(Long id);
    
}
