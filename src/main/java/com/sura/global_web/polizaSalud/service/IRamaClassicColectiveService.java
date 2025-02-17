package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.RequestClassicColectiveDto;
import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.ResponseClassicColectiveDto;
import com.sura.global_web.polizaSalud.model.RamaClassicColective;


public interface IRamaClassicColectiveService {
    

    ResponseClassicColectiveDto createRamaClassicColective(RequestClassicColectiveDto requestClassicColectiveDto);
    List<RamaClassicColective> findClassicColectivesAll();
    RamaClassicColective findClassicColectiveById(Long id);
    RamaClassicColective updateRamaClassicColective(Long id,RamaClassicColective ramaClassicColective);
    String delecteRamaClassicColective(Long id);
}
