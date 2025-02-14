package com.sura.global_web.polizaSalud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sura.global_web.polizaSalud.model.RamaJuvenil;
import com.sura.global_web.polizaSalud.service.imple.RamaJuvenilService;


@RequestMapping("/api/ramaJuvenil")
@RestController
public class RamaJuvenilController {
    
    private final RamaJuvenilService ramaJuvenilService;

    public RamaJuvenilController(RamaJuvenilService ramaJuvenilService) {
        this.ramaJuvenilService = ramaJuvenilService;
    }

    @PostMapping
    public ResponseEntity<RamaJuvenil> createRamaJuvenil(RamaJuvenil ramaJuvenil){
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.ramaJuvenilService.createRamaJuvenil(ramaJuvenil));
    }
    
    @GetMapping
    public ResponseEntity<List<RamaJuvenil>> getAllRamaJuvenil(){
        return ResponseEntity
              .status(HttpStatus.OK)
              .body(this.ramaJuvenilService.findJuvenilAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaJuvenil> getRamaJuvenilById(@PathVariable Long id){
        return ResponseEntity
              .status(HttpStatus.OK)
              .body(this.ramaJuvenilService.findRamaJuvenilByIdJuvenil(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaJuvenil> updateRamaJuvenil(@PathVariable Long id,@RequestBody RamaJuvenil ramaJuvenil){
        return ResponseEntity
              .status(HttpStatus.OK)
              .body(this.ramaJuvenilService.updatJuvenil(id, ramaJuvenil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RamaJuvenil> deleteRamaJuvenil(@PathVariable Long id){
        this.ramaJuvenilService.deleteRamaJuvenilById(id);
        return ResponseEntity
               .status(HttpStatus.OK).build();
    }
}
