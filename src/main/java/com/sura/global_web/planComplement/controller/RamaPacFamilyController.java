package com.sura.global_web.planComplement.controller;


import com.sura.global_web.planComplement.model.RamaPacFamily;
import com.sura.global_web.planComplement.service.impl.RamaPacFamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ramaPacFamily")
public class RamaPacFamilyController {

    private final RamaPacFamilyService ramaPacFamilyService;

    public RamaPacFamilyController(RamaPacFamilyService ramaPacFamilyService) {
        this.ramaPacFamilyService = ramaPacFamilyService;
    }

    @PostMapping
    public ResponseEntity<RamaPacFamily> createRamaPacFamily(@RequestBody RamaPacFamily ramaPacFamily){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ramaPacFamilyService.createRamaPacFamily(ramaPacFamily));
    }

    @GetMapping
    public ResponseEntity<List<RamaPacFamily>> getAllRamaPacFamily(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacFamilyService.findPacFamiliesAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaPacFamily> updateRamaPacFamily(@PathVariable Long id,@RequestBody RamaPacFamily ramaPacFamily){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacFamilyService.updateRamaPacColective(id,ramaPacFamily));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRamaPacFamily(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacFamilyService.deleteRamaPacColective(id));
    }
}
