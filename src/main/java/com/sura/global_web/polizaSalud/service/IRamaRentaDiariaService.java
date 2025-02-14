package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;

public interface IRamaRentaDiariaService {
    

    RamaRentaDiaria createRamaRentaDiaria(RamaRentaDiaria ramaRentaDiaria);
    List<RamaRentaDiaria> findRamaRentaDiariasAllList();
    RamaRentaDiaria findRamaRentaDiariaById(Long id);
    RamaRentaDiaria updatRamaRentaDiaria(Long id,RamaRentaDiaria ramaRentaDiaria);
    String deleteRamaRentaDiaria(Long id);
    

}
