package com.sura.global_web.polizaSalud.controller;


import com.sura.global_web.polizaSalud.model.RamaSaludFamily;
import com.sura.global_web.polizaSalud.service.imple.RamaSaludFamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ramaSaludFamily")
@RestController
public class RamaSaludFamilyController {

    private final RamaSaludFamilyService ramaSaludFamilyService;

    public RamaSaludFamilyController(RamaSaludFamilyService ramaSaludFamilyService) {
        this.ramaSaludFamilyService = ramaSaludFamilyService;
    }

    @PostMapping
    public ResponseEntity<RamaSaludFamily> createRamaSaludFamily(@RequestBody RamaSaludFamily ramaSaludFamily){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ramaSaludFamilyService.createRamaSaludFamily(ramaSaludFamily));
    }

    @GetMapping
    public ResponseEntity<List<RamaSaludFamily>> getAllRamaSaludFamily(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaSaludFamilyService.findRamaSaludFamiliesAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaSaludFamily> getRamaSaludFamilyById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaSaludFamilyService.findRamaSaludFamilyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaSaludFamily> updateRamaSaludFamily(@PathVariable Long id,@RequestBody RamaSaludFamily ramaSaludFamily){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaSaludFamilyService.updateRamaSaludFamily(id,ramaSaludFamily));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RamaSaludFamily> deleteRamaSaludFamily(@PathVariable Long id){
        this.ramaSaludFamilyService.deleteRamaSaludFamily(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
