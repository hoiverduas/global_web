package com.sura.global_web.planComplement.service;

import java.util.List;

import com.sura.global_web.planComplement.model.RamaPacFamily;

public interface IRamaPacFamilyService {
    

    RamaPacFamily createRamaPacFamily(RamaPacFamily ramaPacFamily);
    List<RamaPacFamily> findPacFamiliesAll();
    RamaPacFamily findRamaPacFamilyById(Long id);
    RamaPacFamily updateRamaPacColective(Long id,RamaPacFamily ramaPacFamily);
    String deleteRamaPacColective(Long id);


}
