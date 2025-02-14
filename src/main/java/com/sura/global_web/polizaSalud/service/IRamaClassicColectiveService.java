package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaClassicColective;


public interface IRamaClassicColectiveService {
    

    RamaClassicColective createRamaClassicColective(RamaClassicColective ramaClassicColective);
    List<RamaClassicColective> findClassicColectivesAll();
    RamaClassicColective findClassicColectiveById(Long id);
    RamaClassicColective updateRamaClassicColective(Long id,RamaClassicColective ramaClassicColective);
    String delecteRamaClassicColective(Long id);
}
