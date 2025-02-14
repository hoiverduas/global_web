package com.sura.global_web.planComplement.service.impl;

import java.util.List;
import java.util.Optional;

import com.sura.global_web.planComplement.model.RamaPacColective;
import com.sura.global_web.planComplement.repository.IRamaPacColectiveRepository;
import com.sura.global_web.planComplement.service.IRamaPacColectiveService;
import com.sura.global_web.polizaSalud.model.RamaClassicColective;

public class RamaPacColectiveService implements IRamaPacColectiveService{

    private final IRamaPacColectiveRepository ramaPacColectiveRepository;

    public RamaPacColectiveService(IRamaPacColectiveRepository ramaPacColectiveRepository) {
        this.ramaPacColectiveRepository = ramaPacColectiveRepository;
    }

    @Override
    public RamaPacColective createRamaPacColective(RamaPacColective ramaPacColective) {
        return this.ramaPacColectiveRepository.save(ramaPacColective);
    }

    @Override
    public String deleteRamaPacColective(Long id) {
        findRamaPacColectiveById(id);
        this.ramaPacColectiveRepository.deleteById(id);
        return "fue eliminado exitoxamente"; 
    }

    @Override
    public List<RamaPacColective> findPacColectivesAll() {
        return this.ramaPacColectiveRepository.findAll();
    }

    @Override
    public RamaPacColective findRamaPacColectiveById(Long id) {
        return this.ramaPacColectiveRepository
                   .findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public RamaPacColective updateRamaPacColective(Long id, RamaPacColective ramaPacColective) {

        Optional<RamaPacColective> optionalRamaPacColective = ramaPacColectiveRepository.findById(id);
        if (optionalRamaPacColective.isPresent()) {
            RamaPacColective existRamaPacColective = optionalRamaPacColective.get();

            existRamaPacColective.setCharacteristics(ramaPacColective.getCharacteristics());
            existRamaPacColective.setPacColectives(ramaPacColective.getPacColectives());
            existRamaPacColective.setSubRamaPacColective(ramaPacColective.getSubRamaPacColective());
            
            return this.ramaPacColectiveRepository.save(existRamaPacColective);
        }else{
            throw new RuntimeException("no found");
        }
    }

    
}
