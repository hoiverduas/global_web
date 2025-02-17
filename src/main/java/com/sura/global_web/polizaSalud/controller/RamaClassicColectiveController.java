package com.sura.global_web.polizaSalud.controller;

import java.util.List;

import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.RequestClassicColectiveDto;
import com.sura.global_web.polizaSalud.dto.ramaClassicColetiveDto.ResponseClassicColectiveDto;
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

import com.sura.global_web.polizaSalud.model.RamaClassicColective;
import com.sura.global_web.polizaSalud.service.imple.RamaClassicColectiveService;

@RestController
@RequestMapping("/api/ramaclassicColective")
public class RamaClassicColectiveController {
    
    private final RamaClassicColectiveService ramaClassicColectiveService;

    public RamaClassicColectiveController(RamaClassicColectiveService ramaClassicColectiveService) {
        this.ramaClassicColectiveService = ramaClassicColectiveService;
    }
    

    @PostMapping
    public ResponseEntity<ResponseClassicColectiveDto> createRamaClassicColective(@RequestBody RequestClassicColectiveDto ramaClassicColective){
        return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(this.ramaClassicColectiveService.createRamaClassicColective(ramaClassicColective));
    }

    @GetMapping
    public ResponseEntity<List<RamaClassicColective>> getAllRamaClassicColetive(){
        return ResponseEntity
              .status(HttpStatus.OK)
              .body(this.ramaClassicColectiveService.findClassicColectivesAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamaClassicColective> getRamaClassicColectiveById(@PathVariable Long id){
        return ResponseEntity
               .status(HttpStatus.OK)
               .body(this.ramaClassicColectiveService.findClassicColectiveById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RamaClassicColective> updateRamaClassicColective(@PathVariable Long id,@RequestBody RamaClassicColective ramaClassicColective){
        return ResponseEntity
              .status(HttpStatus.OK)
              .body(this.ramaClassicColectiveService.updateRamaClassicColective(id,ramaClassicColective));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRamaClassicColective(@PathVariable Long id){
        this.ramaClassicColectiveService.delecteRamaClassicColective(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
