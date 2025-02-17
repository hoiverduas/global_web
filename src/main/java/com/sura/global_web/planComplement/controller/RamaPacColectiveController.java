package com.sura.global_web.planComplement.controller;


import com.sura.global_web.planComplement.dto.ramaPacColective.RequestRamaPacColective;
import com.sura.global_web.planComplement.dto.ramaPacColective.ResponseRamaPacColective;
import com.sura.global_web.planComplement.model.RamaPacColective;
import com.sura.global_web.planComplement.service.impl.RamaPacColectiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ramaPacColective")
public class RamaPacColectiveController {

    private final RamaPacColectiveService ramaPacColectiveService;

    public RamaPacColectiveController(RamaPacColectiveService ramaPacColectiveService) {
        this.ramaPacColectiveService = ramaPacColectiveService;
    }

    @PostMapping
    public ResponseEntity<ResponseRamaPacColective> createRamaPacColective(@RequestBody RequestRamaPacColective ramaPacColective){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ramaPacColectiveService.createRamaPacColective(ramaPacColective));
    }

    @GetMapping
    public ResponseEntity<List<RamaPacColective>> getAllRamaPacColective(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacColectiveService.findPacColectivesAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaPacColective> getRamaPacColectiveById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacColectiveService.findRamaPacColectiveById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaPacColective> updateRamaPacColective(@PathVariable Long id,@RequestBody RamaPacColective ramaPacColective){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacColectiveService.updateRamaPacColective(id,ramaPacColective));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRamaPacColective(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.ramaPacColectiveService.deleteRamaPacColective(id));
    }

}
