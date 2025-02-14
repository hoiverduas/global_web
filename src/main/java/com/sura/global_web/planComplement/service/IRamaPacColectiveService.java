package com.sura.global_web.planComplement.service;

import java.util.List;

import com.sura.global_web.planComplement.model.RamaPacColective;
import com.sura.global_web.polizaSalud.model.RamaClassicColective;

public interface IRamaPacColectiveService {


    RamaPacColective createRamaPacColective(RamaPacColective ramaPacColective);
    List<RamaPacColective> findPacColectivesAll();
    RamaPacColective findRamaPacColectiveById(Long id);
    RamaPacColective updateRamaPacColective(Long id,RamaPacColective ramaPacColective);
    String deleteRamaPacColective(Long id);

    
}
