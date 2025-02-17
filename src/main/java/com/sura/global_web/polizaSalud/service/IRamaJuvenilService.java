package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaJuvenil;

public interface IRamaJuvenilService {

    RamaJuvenil createRamaJuvenil(RamaJuvenil ramaJuvenil);
    List<RamaJuvenil> findJuvenilAll();
    RamaJuvenil findRamaJuvenilByIdJuvenil(Long id);
    RamaJuvenil updatJuvenil(Long id,RamaJuvenil ramaJuvenil);
    String deleteRamaJuvenilById(Long id);

    
}
