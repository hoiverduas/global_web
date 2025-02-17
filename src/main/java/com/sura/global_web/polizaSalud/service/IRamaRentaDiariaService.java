package com.sura.global_web.polizaSalud.service;

import java.util.List;

import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.RequestRamaRentaDiariaDto;
import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.ResponseRamaRentaDiariaDto;
import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;

public interface IRamaRentaDiariaService {
    

    ResponseRamaRentaDiariaDto createRamaRentaDiaria(RequestRamaRentaDiariaDto requestRamaRentaDiariaDto);
    List<RamaRentaDiaria> findRamaRentaDiariasAllList();
    RamaRentaDiaria findRamaRentaDiariaById(Long id);
    RamaRentaDiaria updatRamaRentaDiaria(Long id,RamaRentaDiaria ramaRentaDiaria);
    String deleteRamaRentaDiaria(Long id);
    

}
