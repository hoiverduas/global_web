package com.sura.global_web.polizaSalud.controller;


import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.RequestRamaRentaDiariaDto;
import com.sura.global_web.polizaSalud.dto.ramaDiariaRentaDto.ResponseRamaRentaDiariaDto;
import com.sura.global_web.polizaSalud.model.RamaRentaDiaria;
import com.sura.global_web.polizaSalud.service.imple.RamaRentaDiariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ramaRentaDiaria")
public class RamaRentaDiariaController {

    private final RamaRentaDiariaService rentaDiariaService;

    public RamaRentaDiariaController(RamaRentaDiariaService rentaDiariaService) {
        this.rentaDiariaService = rentaDiariaService;
    }


    @PostMapping
    public ResponseEntity<ResponseRamaRentaDiariaDto> createRamaRentaDiaria(@RequestBody RequestRamaRentaDiariaDto ramaRentaDiaria){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.rentaDiariaService.createRamaRentaDiaria(ramaRentaDiaria));
    }

    @GetMapping
    public ResponseEntity<List<RamaRentaDiaria>> getAllRamaRentaDiaria(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.rentaDiariaService.findRamaRentaDiariasAllList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaRentaDiaria> getRamaRentaDiariaById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.rentaDiariaService.findRamaRentaDiariaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaRentaDiaria> updateRamaRentaDiaria(@PathVariable Long id,@RequestBody RamaRentaDiaria ramaRentaDiaria){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.rentaDiariaService.updatRamaRentaDiaria(id,ramaRentaDiaria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RamaRentaDiaria> deleteRamaRentaDiaria(@PathVariable Long id){
        this.rentaDiariaService.deleteRamaRentaDiaria(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
